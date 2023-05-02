function changeImage() {
    const images = ['default3.jpg', 'default4.jpg'];
    const currentImage = document.querySelector('img').src.split('/').pop();
    document.querySelector('img').src = images.find(image => image !== currentImage);
}