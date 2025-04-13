
### 🧑‍💻 코드
---
```java
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            int count = 0;

            while (progresses[i] < 100){
                progresses[i] += speeds[i];
                count++;
            }

            queue.offer(count);
        }

        int deploy = 1;
        int standard = queue.poll();
        while(!queue.isEmpty()){

            if(queue.peek() <= standard){
                deploy++;
                queue.poll();

            } else {
                answer.add(deploy);
                deploy = 1;
                standard = queue.poll();
            }

        }
        answer.add(deploy);
        return answer;
    }
}
```
