### 🧑‍💻 코드
---
```java
import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            
            int prev = stack.peek();
            int current = arr[i];
            
            if(prev != current){
                answer.add(stack.pop());
                stack.push(current);
            }
            
            
        }
        answer.add(stack.pop());
        
        return answer;
    }
}
```
