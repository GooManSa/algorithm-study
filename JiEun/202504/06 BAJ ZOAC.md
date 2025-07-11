```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_16719 {
    public static String str;
    public static StringBuilder sb = new StringBuilder();
    public static String [] answer; // 각 단계에서의 문자열 상태를 저장할 배열

    public static void find(int answerIdx) {
        int idx = 0; // 인덱스 초기화

        // StringBuilder의 왼쪽부터 비교하며 최선의 선택을 함
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) < sb.charAt(idx)) break; //현재 문자가 다음에 오는 문자보다 빠르다면 for문 종료
            idx = i;
        }

        sb.deleteCharAt(idx); // 찾은 인덱스 문자 삭제
        answer[answerIdx] = sb.toString(); // 현재 상태 저장
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        sb.append(str);

        int length = str.length();
        answer = new String[length]; // 문자열 길이만큼 answer 배열 초기화
        answer[length-1] = str;
        for(int i=length-2; i>=0; i--) find(i);
        for(String s : answer) System.out.println(s); //결과 출력 
    }
}
```