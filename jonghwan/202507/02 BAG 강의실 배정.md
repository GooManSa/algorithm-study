```js
//11000번 강의실 배정
const fs = require('fs');

const input = require('fs')
  .readFileSync('/dev/stdin', 'utf8')
  .trim()
  .split(/\s+/)
  .map(Number);

const N = Number(input[0]);

const answer = [];
for (let i = 0, idx = 1; i < N; i++, idx += 2) {
  answer.push([input[idx], input[idx + 1]]);
}

answer.sort((a, b) => (a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]));

class MinHeap {
  constructor() {
    this.h = [];
  }

  size() {
    return this.h.length;
  }

  top() {
    return this.h[0];
  }

  push(v) {
    const h = this.h;
    h.push(v);
    for (let c = h.length - 1; c > 0; ) {
      const p = (c - 1) >> 1;
      if (h[p] <= h[c]) break;
      [h[p], h[c]] = [h[c], h[p]];
      c = p;
    }
  }
  pop() {
    const h = this.h;
    if (!h.length) return;
    const root = h[0],
      last = h.pop();
    if (h.length) {
      h[0] = last;
      for (let p = 0, len = h.length; ; ) {
        let l = p * 2 + 1,
          r = l + 1,
          nxt = p;
        if (l < len && h[l] < h[nxt]) nxt = l;
        if (r < len && h[r] < h[nxt]) nxt = r;
        if (nxt === p) break;
        [h[p], h[nxt]] = [h[nxt], h[p]];
        p = nxt;
      }
    }
    return root;
  }
}

const pq = new MinHeap();
for (const [s, e] of answer) {
  if (pq.size() && pq.top() <= s) pq.pop();
  pq.push(e);
}
console.log(pq.size().toString());
```
