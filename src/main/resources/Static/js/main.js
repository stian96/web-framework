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

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if(username)
    {
        firstPage.classList.add('hidden');
        secondPage.classList.remove('hidden');

        client = Stomp.over(new SockJS('/ws'));
        client.connect({}, whenConnected);
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
    const message = JSON.parse(information.body);

    const messageElement = document.createElement('li');

    if(message.type === 'JOIN')
    {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    }
    else if (message.type === 'LEAVE')
    {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    }
    else
    {
        messageElement.classList.add('chat-message');

        const avatarElement = document.createElement('i');
        const avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = randomColor(message.sender);

        messageElement.appendChild(avatarElement);

        const usernameElement = document.createElement('span');
        const usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    const textElement = document.createElement('p');
    const messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    chatField.appendChild(messageElement);
    chatField.scrollTop = chatField.scrollHeight;
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