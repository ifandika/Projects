
/**
 * Get html elemen
 */
const elemenContainer = document.querySelector('.container');
const idBoxSquare = document.getElementById('box-square');
const idBtnPlay1Save = document.getElementById('play1-btn-save');

console.log(elemenContainer.clientWidth);

const sleep = (ms) => new Promise(resolve => setTimeout(resolve, ms));

const box1 = {
  kecepatan: 0,
  percepatan: 5,
  waktu: 0
}

function updateKecepatan(deltaTime) {
    box1.waktu += deltaTime;
    box1.kecepatan = box1.percepatan * box1.waktu;
    return box1.kecepatan;
}

idBtnPlay1Save.addEventListener('click', async () => {
  for(let index = 0; index < 20; index++) {
    const position = updateKecepatan(index);
    idBoxSquare.style.left = position + 'px';
    await sleep(50);
  }
});

