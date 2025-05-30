```java
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times); //오름차순 정렬
        
        long left = 0; //가장 짧은 시간
    	long right = (long) times[times.length-1]*n; //가장 긴 시간
        long mid = 0;
    	long total; //현재 시간동안 처리 가능한 사람 수
    	long answer = right; //최소 시간의 최댓값으로 초기화

        //이진 탐색
    	while(left <= right) {
    		total = 0;
    		mid = (left + right) / 2; // 중간값 계산 

            //각 심사관이 mid 시간 동안 몇 명을 처리할 수 있는지
    		for(int time : times) { 
    			total += mid / time;
    		}

    		if(total >= n) { //충분히 많은 사람을 처리할 수 있는 경우
				answer = mid;
				right = mid - 1; //시간 줄이기
    		}
    		else { 
    			left = mid + 1; //시간 늘리기
    		}
        }
        
        return answer; //최소 시간 반환
    }
}
```