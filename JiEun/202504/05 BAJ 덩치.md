```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //전체 사람 수
        int [][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //몸무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //키
        }

        int [] answer = new int[N]; //덩치의 등수를 저장할 배열
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) answer[i] += 1; //j가 더 크면 i의 등수 낮춤
                else if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]) answer[j] += 1; //i가 더 크면 i의 등수를 낮춤
            }
        }

        for (int n : answer) System.out.print((n+1) +" "); //공백을 두고 등수 출력. 기본 등수는 1부터이기 때문에 +1
    }
}
```