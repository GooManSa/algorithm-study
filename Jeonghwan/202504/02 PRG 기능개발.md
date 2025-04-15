```
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();

        int days = 0;
        int idx = 0;
        while (idx < progresses.length) {
            int deploy = 0;
            while (idx < progresses.length &&
                   progresses[idx] + (speeds[idx] * days) >= 100) {
                idx++;
                deploy++;
            }
            if (deploy > 0) {
                answer.add(deploy);
            }
            days++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
```
