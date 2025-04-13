``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0; //잘려진 조각의 총 개수
        Stack<Character> stack = new Stack<>();
        
        int idx = 0; //현재 쇠막대기 위치를 나타낼 인덱스
        while(idx < str.length()) {
            char c = str.charAt(idx); //현재 쇠막대기의 괄호
            if(c == '(') { //여는 괄호일 때
                if(str.charAt(idx+1) == ')') { //레이저일 때
                    answer += stack.size(); //레이저로 잘렸을 때 막대기 수
                    idx++;
                } else {
                    stack.push(c);
                }
            } else { //닫는 괄호일 때
                stack.pop();
                answer += 1; //잘린 막대기 수 추가
            }
            idx++;
        }

        System.out.println(answer);
    }
}
```