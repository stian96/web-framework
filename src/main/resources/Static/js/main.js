'use strict';

const firstPage = document.querySelector('#first-page');
const secondPage = document.querySelector('#second-page');
const nameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const input = document.querySelector('#message');
const chatField = document.querySelector('#messageArea');
const connecting = document.querySelector('.connecting');

let client = null;
let username = null;
let connectedUsers = 0;

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username)
    {
        if (connectedUsers < 1)
        {
            connectedUsers += 1;
            firstPage.classList.add('hidden');
            secondPage.classList.remove('hidden');

            client = Stomp.over(new SockJS('/ws'));
            client.connect({}, whenConnected);
        }
        else
        {
            alert("This is a private chat, only two people are allowed!");
            event.preventDefault();
            client.disconnect();
        }

    }
    event.preventDefault();
}

function whenConnected() {
    client.subscribe('/subject/public', whenReceived);
    client.send("/chat/addUser", {}, JSON.stringify({sender: username, type: 'JOIN'}))
    connecting.classList.add('hidden');
}

function send(event) {
    const content = input.value.trim();
    if(content && client)
    {
        const message =
            {
                sender: username,
                content: input.value,
                type: 'CHAT'
            };

        client.send("/chat/sendMessage", {}, JSON.stringify(message));
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