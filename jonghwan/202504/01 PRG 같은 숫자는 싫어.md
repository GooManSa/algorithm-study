📌 문제 링크

프로그래머스 같은 숫자는 싫어

📍 문제 접근

- javascript 처럼 풀려다가 머리가 땅 하고 맞은거 같아서 자바의 정석처럼 풀었습니다.
- 숫자를 prev 배열에 넣고 배열의 같은값이 있으면 prev 배열에 넣지 않고 그냥 반복

⏳ 수행 시간

- 20분

✅ 테스트 인증

![image](../../image/스택1.png)

⏰ 시간 복잡도
O(N)
🧑‍💻 코드

```js
let answer = [];
for (let i = 0; i < arr.length; i++) {
  if (arr[i] !== arr[i + 1]) answer.push(arr[i]);
}
return answer;
```

기가막힌 js처럼 풀기 코드

```js
return arr.filter((val, index) => val != arr[index + 1]);
```
