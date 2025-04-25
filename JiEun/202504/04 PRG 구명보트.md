```java
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //오름차순 정렬

        int leftIdx = 0; //현시점 가장 가벼운 사람
        int rightIdx = people.length-1; //현시점 가장 무거운 사람
        //투 포인트를 이용한 탐색
        while(leftIdx <= rightIdx) {
            //가벼운 사람+무거운 사람이 구명보트 무게 제한 이하일 경우
            if(people[leftIdx] + people[rightIdx] <= limit) leftIdx++;
            rightIdx--;
            answer++; //구명 보트 한대 사용
        }

        return answer;
    }
}
```