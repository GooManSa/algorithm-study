```js
/**
 * @param {number[]} nums
 * @return {number}
 */
let jump = function (nums) {
  const n = nums.length;
  if (n <= 1) return 0;

  let jumps = 0;
  let currentEnd = 0;
  let fartherst = 0;

  for (let i = 0; i < n - 1; i++) {
    fartherst = Math.max(fartherst, i + nums[i]);

    if (i === currentEnd) {
      jumps++;
      currentEnd = fartherst;
    }
  }

  return jumps;
};
```
