```js
function solution(name) {
  let updown = 0;
  let move = name.length - 1;
  let Aindex = 0;
  let AtoZ = Array(name.length).fill('A').join('');

  for (let i = 0; i < name.length; i++) {
    let asciiName = name.charCodeAt(i);
    let asciiChar = AtoZ.charCodeAt(i);

    if (asciiName <= 78) {
      updown += asciiName - asciiChar;
    } else {
      updown += 91 - asciiName;
    }

    // A 위치 기억하기
    Aindex = i;
    while (name.at(Aindex) == 'A') {
      Aindex += 1;
    }

    if (i == 0) {
      move = Math.min(name.length - Aindex, move);
    } else {
      move = Math.min(2 * (i - 1) + name.length - Aindex, move);
      move = Math.min(move, i - 1 + (name.length - Aindex) * 2);
    }
  }
  return updown + move;
}
```
