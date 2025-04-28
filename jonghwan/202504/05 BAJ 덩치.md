```js
// baekjoon 7568번 덩치
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin', 'utf8').trim().split('\n');

const N = +input[0];
const people = input.slice(1).map((line) => {
  const [w, h] = line.split(' ').map(Number);
  return {w, h};
});

// 등수 배열을 1로 초기화
const rank = Array(N).fill(1);

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (people[j].w > people[i].w && people[j].h > people[i].h) {
      rank[i]++;
    }
  }
}

console.log(rank.join(' '));
```
