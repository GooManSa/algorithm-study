```js
/**
 * @param {number} n
 * @return {number[][]}
 */
const generateMatrix = function (n) {
  const matrix = Array.from({length: n}, () => Array(n).fill(0));
  let top = 0,
    bottom = n - 1;
  let left = 0,
    right = n - 1;
  let num = 1,
    max = n * n;

  while (num <= max) {
    // 1) 위쪽 행: left → right
    for (let j = left; j <= right; j++) {
      matrix[top][j] = num++;
    }
    top++;

    // 2) 오른쪽 열: top → bottom
    for (let i = top; i <= bottom; i++) {
      matrix[i][right] = num++;
    }
    right--;

    // 3) 아래쪽 행: right → left
    for (let j = right; j >= left; j--) {
      matrix[bottom][j] = num++;
    }
    bottom--;

    // 4) 왼쪽 열: bottom → top
    for (let i = bottom; i >= top; i--) {
      matrix[i][left] = num++;
    }
    left++;
  }

  return matrix;
};
```
