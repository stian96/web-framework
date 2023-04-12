'use strict';

let wsEndpoint;
let brokerPrefix;
let appDestinationPrefix;

const firstPage = document.querySelector('#first-page');
const secondPage = document.querySelector('#second-page');
const nameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const input = document.querySelector('#message');
const chatField = document.querySelector('#messageArea');
const chatRoomTitle = document.querySelector('#chat-room-title');

const iconImages = [ 'images/image.jpg'];

// Object list over users
let connectedUsers = JSON.parse(localStorage.getItem('connectedUsers')) || [];
let stompClient = null;
let username = null;
let chatMethod = null;


// Fetch private value from spring servlet
fetch('/springServlet').then(function(response) {
    return response.text();
}).then(function(value) {
    chatMethod = value;
    console.log("Chat method: " + value);
});


// Fetch configuration data from the ChatConfigController
function fetchChatConfig() {
    fetch('/api/chat-config')
        .then(response => response.json())
        .then(config => {
            wsEndpoint = config.wsEndpoint;
            brokerPrefix = config.brokerPrefix;
            appDestinationPrefix = config.appDestinationPrefix;

        })
        .catch(error => {
            console.error("Error fetching chat config:", error);
        });
}

fetchChatConfig();

function connect(event) {
    console.log("Chat method: " + chatMethod);

    username = document.querySelector('#name').value.trim();


    if (connectedUsers.some(user => user.username === username)) {
        alert("You are already connected to the chat!");
        return;
    }

    if (connectedUsers.length >= 2 && parseInt(chatMethod) === 0) {
        alert("Only two users in private chat!");
        return;
    }

    if (parseInt(chatMethod) === 0) {
        chatRoomTitle.textContent = "Private Chat";
    }
    else {
        chatRoomTitle.textContent = "Group Chat";
    }

    if (username && username.trim().length > 0) {

        firstPage.classList.add('hidden');
        secondPage.classList.remove('hidden');

        stompClient = Stomp.over(new SockJS(wsEndpoint));
        stompClient.connect({}, whenConnected);

        connectedUsers.push({
            username,
            clientId: stompClient.clientId,
        });
        localStorage.setItem('connectedUsers', JSON.stringify(connectedUsers));
        event.preventDefault();
    }
}

function handleUnload() {
    const username = getUsernameByClientId(stompClient.clientId);

    if (!username) {
        return;
    }

    connectedUsers = connectedUsers.filter(user => user.username !== username);
    localStorage.setItem('connectedUsers', JSON.stringify(connectedUsers));

    if (connectedUsers.length === 0) {
        localStorage.removeItem('connectedUsers');
    }
}

window.addEventListener('unload', handleUnload);

function getUsernameByClientId(clientId) {
    const user = connectedUsers.find(user => user.clientId === clientId);
    return user ? user.username : null;
}

function whenConnected() {
    stompClient.subscribe(brokerPrefix, whenReceived);
    stompClient.send(appDestinationPrefix + "/addUser", {}, JSON.stringify({sender: username, type: 'CONNECT'}))
}


function send(event) {
    const content = input.value.trim();
    if(content && stompClient)
    {
        const message =
            {
                sender: username,
                content: input.value,
                type: 'CHAT'
            };
        stompClient.send(appDestinationPrefix + "/sendMessage", {}, JSON.stringify(message));
        input.value = '';
    }
    event.preventDefault();
}


function whenReceived(information) {
    const userMessage = JSON.parse(information.body);

    const messageElement = document.createElement('li');

    if (userMessage.type === 'CONNECT')
    {
        messageElement.classList.add('event-message');
        userMessage.content = userMessage.sender + ' connected!';
    }
    else if (userMessage.type === 'DISCONNECT')
    {
        messageElement.classList.add('event-message');
        userMessage.content = userMessage.sender + ' disconnected!';
    }
    else
    {
        messageElement.classList.add('chat-message');
        handleAvatarAndUserName(userMessage, messageElement);
    }

    const textElement = document.createElement('p');
    const messageText = document.createTextNode(userMessage.content);
    textElement.appendChild(messageText);
    messageElement.appendChild(textElement);

    chatField.appendChild(messageElement);
    chatField.scrollTop = chatField.scrollHeight;
}

function handleAvatarAndUserName(message, messageElement) {
    const element = document.createElement('div');
    const img = document.createElement('img');

    img.src = getRandomImage(message.sender);
    element.appendChild(img);

    messageElement.appendChild(element);

    const usernameElement = document.createElement('span');
    const usernameText = document.createTextNode(message.sender);

    usernameElement.appendChild(usernameText);
    messageElement.appendChild(usernameElement);
}


function getRandomImage(str) {
    let hash = 0;
    if (str.length === 0) {
        return hash;
    }
    for (let i = 0; i < str.length; i++) {
        const char = str.charCodeAt(i);
        hash = ((hash << 5) - hash) + char;
        hash = hash & hash;
    }
    const index = Math.abs(hash % iconImages.length);
    return iconImages[index];
}

nameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)