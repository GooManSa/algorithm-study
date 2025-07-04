```java
import java.io.*;
import java.util.*;

//  오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수
// NGE(i) = Ax = i < x && Ai < Ax && min(x1, x2, ...)
// Ai를 기준으로 내림차순 구간과 오름차순 구간을 구해야함

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] dest = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dest[i] = -1;
        }

        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int idx = i;
            int num = seq[i];

            while (!stack.isEmpty() && stack.peek()[0] < num) {
                int[] head = stack.poll();
                dest[head[1]] = num;
            }

            stack.push(new int[]{num, idx});
        }

        for (int i : dest) {
            System.out.print(Integer.toString(i) + " ");
        }
    }
}

```
