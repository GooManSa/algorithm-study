```java
import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int moveMin = name.length()-1; // 최소 이동 횟수
        
        for(int now = 0; now < name.length(); now++) {
            char c = name.charAt(now);
            
            // 연속된 알파벳 A가 끝나는 지점 찾기
            int next = now+1;
            while(next < name.length() && name.charAt(next) == 'A') next++;
            
            // 커서 좌우 이동 최소 횟수 구하기
            moveMin = Math.min(moveMin, Math.min(((now*2) + name.length() - next), ((name.length()-next)*2 + now)));
            
            // 알파벳 조이스틱
            answer += Math.min(c-'A', 'Z'-c+1);
        }
        answer += moveMin;
        return answer;
    }
}
```