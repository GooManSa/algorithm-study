```js
const fs = require('fs');
const inputLines = fs.readFileSync(0, 'utf-8').trim().split('\n');

const [N, M] = inputLines[0].split(' ').map(Number);
const parent = Array.from({length: N + 1}, (_, i) => i);
const answer = [];

function find(x) {
  if (parent[x] !== x) parent[x] = find(parent[x]);
  return parent[x];
}

function union(x, y) {
  const rx = find(x),
    ry = find(y);
  if (rx !== ry) parent[rx] = ry;
}

for (let i = 1; i <= M; i++) {
  const [type, a, b] = inputLines[i].split(' ').map(Number);
  if (type === 0) union(a, b);
  else answer.push(find(a) === find(b) ? 'YES' : 'NO');
}

console.log(answer.join('\n'));
```
