```js
/**
 * @param {string} s
 * @return {string}
 */
function longestPalindrome(s) {
  if (!s || s.length < 2) return s;

  // 팰린드롬 확장 헬퍼
  function expandAroundCenter(left, right) {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  let start = 0,
    end = 0;
  for (let i = 0; i < s.length; i++) {
    const len1 = expandAroundCenter(i, i);
    const len2 = expandAroundCenter(i, i + 1);
    const len = Math.max(len1, len2);
    if (len > end - start + 1) {
      start = i - Math.floor((len - 1) / 2);
      end = i + Math.floor(len / 2);
    }
  }
  return s.slice(start, end + 1);
}
```
