## 2667번 단지번호붙이기

```js
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const n = Number(input[0]);
const grid = input.slice(1).map((line) => line.split('').map(Number));

const visited = Array.from({length: n}, () => Array(n).fill(false));

function solution() {
  const answer = [];

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 1 && !visited[i][j]) {
        answer.push(dfs(i, j));
      }
    }
  }

  return answer;
}

const dir = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];

function dfs(dx, dy) {
  const stack = [];
  stack.push([dx, dy]);
  visited[dx][dy] = true;
  let count = 1;

  while (stack.length > 0) {
    const [x, y] = stack.pop();

    for (const [dx, dy] of dir) {
      const ny = y + dy;
      const nx = x + dx;

      if (
        nx >= 0 &&
        nx < n &&
        ny >= 0 &&
        ny < n &&
        !visited[nx][ny] &&
        grid[nx][ny] === 1
      ) {
        visited[nx][ny] = true;
        stack.push([nx, ny]);
        count++;
      }
    }
  }
  return count;
}

const result = solution();
const output = [result.length, ...result.sort((a, b) => a - b)].join('\n');
console.log(output);

//dfs 로 스택을 쌓아서 한 column에 쌓아서

// 7
// 0110100
// 0110101
// 1110101
// 0000111
// 0100000
// 0111110
// 0111000

//bfs
// function bfs(sx, sy) {
//   const queue = [[sx, sy]];
//   visited[sx][sy] = true;
//   let count = 1;

//   while (queue.length > 0) {
//     const [x, y] = queue.shift();

//     for (const [dx, dy] of dir) {
//       const nx = x + dx;
//       const ny = y + dy;

//       if (
//         nx >= 0 &&
//         nx < n &&
//         ny >= 0 &&
//         !visited[nx][ny] &&
//         grid[nx][ny] === 1
//       ) {
//         visited[nx][ny] = true;
//         queue.push([nx, ny]);
//         count++;
//       }
//     }
//   }
//   return count;
// }

// function solution() {
//   const answer = [];

//   for (let i = 0; i < n; i++) {
//     for (let j = 0; j < n; j++) {
//       if (grid[i][j] === 1 && !visited[i][j]) {
//         answer.push(bfs(i, j));
//       }
//     }
//   }
// }
```
