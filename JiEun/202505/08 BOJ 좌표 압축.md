```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌표의 개수
        int [] arr = new int[N]; //좌표를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] copy = arr.clone(); //좌표를 담은 배열 복사
        Arrays.sort(copy); //복사한 배열 오름차순 정렬
        int idx = 0; //좌표 압축 시작
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++) {
            if(!map.containsKey(copy[i])) { //map에 들어가 있지 않은 좌표 값만 계산
                map.put(copy[i], idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arr) sb.append(map.get(n)).append(" "); //좌표 압축 결과 StringBuilder에 담기
        System.out.println(sb); //결과 출력
    }
}
```