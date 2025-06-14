```JS

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const searchRange = function(nums, target) {
 function findLeft(nums, target) {
  let lo = 0, hi = nums.length - 1;
  let idx = -1;
  while (lo <= hi) {
    const mid = Math.floor((lo + hi) / 2);
    if (nums[mid] < target) {
      lo = mid + 1;
    } else {
      // nums[mid] >= target 이면 왼쪽을 더 뒤져본다
      if (nums[mid] === target) idx = mid;
      hi = mid - 1;
    }
  }
  return idx;
}


function findRight(nums, target) {
 const left = findLeft(nums, target);
  if (left === -1) {
    // target이 배열에 없으면 [-1, -1] 바로 반환
    return [-1, -1];
  }
  const right = findRight(nums, target);
  return [left, right];


  let lo = 0, hi = nums.length - 1;
  let idx = -1;
  while (lo <= hi) {
    const mid = Math.floor((lo + hi) / 2);
    if (nums[mid] > target) {
      hi = mid - 1;
    } else {
      // nums[mid] <= target 이면 오른쪽을 더 뒤져본다
      if (nums[mid] === target) idx = mid;
      lo = mid + 1;
    }
  }
  return idx;
}
};

```
