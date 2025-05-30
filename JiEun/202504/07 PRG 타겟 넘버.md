```java
class Solution {
    public int answer = 0; // target을 만들 수 있는 경우의 수
    public void find(int [] numbers, int depth, int num, int target) {
        if(depth == numbers.length) { // 주어진 숫자를 다 사용했을 경우
            if(num == target) answer++; // 타겟 넘버와 같다면, 경우의 수 up
            return;
        }
        find(numbers, depth+1, num+numbers[depth], target); //현재 숫자를 더한 뒤 재귀
        find(numbers, depth+1, num-numbers[depth], target); //현재 숫자를 뺀 뒤 재귀
    }
    
    public int solution(int[] numbers, int target) {
        find(numbers, 0, 0, target);
        return answer; // 최종 경우의 수 반환
    }
}
```