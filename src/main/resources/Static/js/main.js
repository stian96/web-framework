'use strict';

const firstPage = document.querySelector('#first-page');
const secondPage = document.querySelector('#second-page');
const nameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const input = document.querySelector('#message');
const chatField = document.querySelector('#messageArea');

// Object list over users
let connectedUsers = JSON.parse(localStorage.getItem('connectedUsers')) || [];
let stompClient = null;
let username = null;

function connect(event) {

    username = document.querySelector('#name').value.trim();


    if (connectedUsers.some(user => user.username === username)) {
        alert("You are already connected to the chat!");
        return;
    }

    if (connectedUsers.length >= 2) {
        alert("Only two users in private chat!");
        return;
    }

    if (username && username.trim().length > 0) {

        firstPage.classList.add('hidden');
        secondPage.classList.remove('hidden');

        stompClient = Stomp.over(new SockJS('/ws'));
        stompClient.connect({}, whenConnected);

        connectedUsers.push({
            username,
            clientId: stompClient.clientId
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
    stompClient.subscribe('/subject/public', whenReceived);
    stompClient.send("/chat/addUser", {}, JSON.stringify({sender: username, type: 'JOIN'}))
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

        stompClient.send("/chat/sendMessage", {}, JSON.stringify(message));
        input.value = '';
    }
    event.preventDefault();
}


function whenReceived(information) {
    const userMessage = JSON.parse(information.body);

    const messageElement = document.createElement('li');

    if (userMessage.type === 'JOIN')
    {
        messageElement.classList.add('event-message');
        userMessage.content = userMessage.sender + ' joined!';
    }
    else if (userMessage.type === 'LEAVE')
    {
        messageElement.classList.add('event-message');
        userMessage.content = userMessage.sender + ' left!';
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
    const element = document.createElement('i');
    const text = document.createTextNode(message.sender[0]);

    element.appendChild(text);
    element.style['background-color'] = randomColor(message.sender);
    messageElement.appendChild(element);

    const usernameElement = document.createElement('span');
    const usernameText = document.createTextNode(message.sender);

    usernameElement.appendChild(usernameText);
    messageElement.appendChild(usernameElement);
}


const iconColors = [ '#F39C12', '#27AE60', '#00BCD4', '#34495E', '#1ABC9C', '#F4D03F', '#9B59B6', '#FF5733'];

function randomColor(message) {
    let value = 1;
    for (let i = 0; i < message.length; i++)
    {
        value = 2 * (value + message.charCodeAt(i));
    }
    const index = Math.abs(value % iconColors.length);
    return iconColors[index];
}

nameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)