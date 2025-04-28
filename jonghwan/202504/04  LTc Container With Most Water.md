```js
/**
 * @param {number[]} height
 * @return {number}
 */
const maxArea = function (height) {
  let l = 0,
    r = height.length - 1;
  let maxArea = 0;

  while (l < r) {
    const width = r - l;
    const h = Math.min(height[l], height[r]);
    maxArea = Math.max(maxArea, width * h);

    if (height[l] < height[r]) {
      l++;
    } else {
      r--;
    }
  }

  return maxArea;
};
```
