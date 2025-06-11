```java
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int [][] dp = new int[n+1][m+1];
        for(int [] arr : puddles) dp[arr[1]][arr[0]] = -1; //물에 잠긴 지역 표기
        dp[1][1] = 1; //출발점 경로 1로 지정

        //DP를 이용하여 경로의 수 계산
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(dp[i][j] == -1) continue; //물에 잠긴 지역은 건너뜀
                if(dp[i-1][j] > 0) dp[i][j] += dp[i-1][j]; //위에서 오는 경로 더함
                if(dp[i][j-1] > 0) dp[i][j] += dp[i][j-1]; //왼쪽에서 오는 경로 더함
                dp[i][j] %= 1_000_000_007; //큰 수 방지 위해 나머지 연산
            }
        }
        return dp[n][m];
    }
}
```