'use strict';

const firstPage = document.querySelector('#first-page');
const secondPage = document.querySelector('#second-page');
const nameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const input = document.querySelector('#message');
const chatField = document.querySelector('#messageArea');
const sendBtn = document.querySelector('.submit-username');

const maxUsers = 2;


let stompClient = null;
let username = null;
let connectedUsers = parseInt(localStorage.getItem('connectedUsers')) || 0;

(function() {
    if (connectedUsers >= maxUsers) {
        alert("Only two users in private chat!");
        sendBtn.style.display = "none";
    }
    connectedUsers++;
})();

function connect(event) {

    localStorage.setItem('connectedUsers', connectedUsers.toString());
    username = document.querySelector('#name').value.trim();

    if(username)
    {
        firstPage.classList.add('hidden');
        secondPage.classList.remove('hidden');

        stompClient = Stomp.over(new SockJS('/ws'));
        stompClient.connect({}, whenConnected);
    }
    event.preventDefault();
}

function handleUnload() {
    if (connectedUsers <= 0)
    {
        localStorage.removeItem('connectedUsers');
    }
    else
    {
        connectedUsers--;
        localStorage.setItem('connectedUsers', connectedUsers.toString());
    }
}

window.addEventListener('unload', handleUnload);

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