```java
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n - lost.length;
        
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for(int reserveStudent : reserve){
            reserveSet.add(reserveStudent);
        }
        
        for(int lostStudent : lost){
            lostSet.add(lostStudent);
        }
        
        // 여벌 체육복을 가졌지만 도난당한 사람
       
       for(int i = 0; i < reserve.length; i++){
            int it = reserve[i];
            if(lostSet.contains(it)){
                answer++;
                lostSet.remove(it);
                reserveSet.remove(it);
            }
        }
        
        // 그냥 도난당한 사람
        Iterator<Integer> lostIt = lostSet.iterator();
        while(lostIt.hasNext()){
            int it = lostIt.next();
            if(reserveSet.contains(it - 1)){
                answer++;
                reserveSet.remove(it-1);
            } else if(reserveSet.contains(it + 1)){
                answer++;
                reserveSet.remove(it+1);
            }
        }        
        
        
        return answer;
    }
}
```