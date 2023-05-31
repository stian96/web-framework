// Code inspired from RAJEEV SINGH, available on https://www.callicoder.com/spring-boot-websocket-chat-example/

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

let connectedUsers = JSON.parse(localStorage.getItem('connectedUsers')) || [];
let stompClient = null;
let username = null;
let chatMethod = null;
let timeStamp = false;
let deleteBtn = null;
let chatRoomTitle = document.querySelector('#chat-room-title');
const iconImages = [ 'images/default1.jpg', 'images/default2.jpg', 'images/image1.jpg', 'images/image2.jpg'];


fetch('/springServlet').then(function(response) {
    return response.json();
}).then(function(data) {
    chatMethod = parseInt(data.chatMethod);
    timeStamp = Boolean(data.timeStamp);
    chatRoomTitle.textContent = data.title;
    deleteBtn = parseInt(data.deleteButton);

    console.log("Chat method: " + chatMethod);
    console.log("Time stamp: " + timeStamp);
    console.log("Title: " + chatRoomTitle.textContent);
    console.log("Button: " + deleteBtn);
});

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

    if (!privateChatAlerts(connectedUsers, chatMethod))
        return;

    checkTitle(chatMethod, chatRoomTitle);
    addClients(username);
    event.preventDefault();
}

function addClients(name) {

    if (name && name.trim().length > 0) {

        addAndRemovePage(firstPage, secondPage);
        createNewStompClient(name);
    }
}

function createNewStompClient(username) {

    stompClient = Stomp.over(new SockJS(wsEndpoint));
    stompClient.connect({}, whenConnected);

    connectedUsers.push({
        username,
        clientId: stompClient.clientId,
    });
    localStorage.setItem('connectedUsers', JSON.stringify(connectedUsers));
}

function addAndRemovePage(first, last) {
    first.classList.add('hidden');
    last.classList.remove('hidden');
}

function checkTitle(method, title) {

    if (parseInt(method) === 0 && title.textContent === "") {
        chatRoomTitle.textContent = "Private Chat";
    }
    else if (parseInt(method) === 1 && title.textContent === ""){
        chatRoomTitle.textContent = "Group Chat";
    }
}

function privateChatAlerts(users, method) {

    if (users.some(user => user.username === username)) {
        alert("You are already connected to the chat!");
        return false;
    }

    if (users.length >= 2 && parseInt(method) === 0) {
        alert("Only two users in private chat!");
        return false;
    }
    return true;
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
    const messageTimestamp = new Date().toLocaleTimeString();

    const timestampSpan = document.createElement('p');
    const deleteIcon = document.createElement('p');
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
        handleImageAndUserName(userMessage, messageElement);

        if (timeStamp === true) {
            const time = document.createTextNode(`${messageTimestamp}`);
            timestampSpan.classList.add('timestamp');
            timestampSpan.appendChild(time);
        }
        if (deleteBtn === 0) {
            createDeleteButton(deleteIcon, messageElement);
        }
    }

    const textElement = document.createElement('p');
    const messageText = document.createTextNode(userMessage.content);
    textElement.appendChild(messageText);

    textElement.appendChild(timestampSpan);
    messageElement.appendChild(textElement);

    chatField.appendChild(messageElement);
    chatField.scrollTop = chatField.scrollHeight;
}

function createDeleteButton(deleteIcon, messageElement) {

    deleteIcon.innerHTML = '&times;';
    deleteIcon.classList.add('delete-icon');

    deleteIcon.addEventListener('click', () => {
        messageElement.remove();
    });
    messageElement.appendChild(deleteIcon);
}


function handleImageAndUserName(message, messageElement) {
    const element = document.createElement('div');
    const img = document.createElement('img');

    img.src = getRandomImage(message.sender);

    img.onerror = function() {
        img.src = iconImages[Math.floor(Math.random() * 2) + 1]
    };

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