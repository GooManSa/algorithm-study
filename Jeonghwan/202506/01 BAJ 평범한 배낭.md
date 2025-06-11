```java
import java.util.*;
import java.io.*;


// 물건이 한개 일경우 -> 배낭에 담을 수 있나, 없나
// 물건이 두 개일 경우 -> 물건을 한개 담을 수 있는가 + 남은 한 개를 담을 수 있는가

public class Main {
    public static int solution(int[] w, int[] v, int[][] dp, int idx) {
        int k = dp[0].length;

        for (int i = 0; i < k; i++) {
            if (idx == 0) {
                int last = 0;
                int cur = w[idx] <= i ? v[idx]: 0;
                dp[idx][i] = Math.max(last, cur);
            } else {
                int last = dp[idx - 1][i];
                int cur = 0;
                if (w[idx] <= i) {
                    cur = v[idx] + dp[idx - 1][i - w[idx]];
                }
                dp[idx][i] = Math.max(last, cur);
            }
        }

        return dp[idx][k - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());

        }
        int[][] dp = new int[n][k+1];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = solution(w, v, dp, i);
        }
        System.out.println(answer);

    }
}

```
