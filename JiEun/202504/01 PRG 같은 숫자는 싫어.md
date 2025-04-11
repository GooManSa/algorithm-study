### 방법 1 - List 활용
``` java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // 방법 1
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            if(list.get(list.size() -1) != arr[i]) { //연속되는 수가 아닐 경우
                list.add(arr[i]); // 리스트에 추가
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray(); // list를 int배열로 변환
        
        return answer;
    }
}
````

### 방법 2 - Stack 활용
``` java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        for(int n : arr) {
            if(!stack.isEmpty()) { // 스택이 비어있지 않은 경우
                if(stack.peek() == n) continue; // 최상단 값과 현재 값이 같으면 중복이므로 건너뜀
            }
            stack.push(n);
        }

        answer = new int[stack.size()]; // 스택의 크기만큼 정답 배열 생성
        int idx = stack.size()-1;
        while(!stack.isEmpty()) { 
            answer[idx--] = stack.pop(); // 스택을 꺼내면서 배열에 역순으로 넣음
        }
       
        return answer;
    }
}
````
