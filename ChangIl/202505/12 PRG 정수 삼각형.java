import java.io.*;
import java.util.*;


class Solution {
    public int solution(int[][] triangle) {

        int n = triangle.length;

        if (n == 1) return triangle[0][0];

        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

//         List<List<Integer>> dp = new ArrayList<>();

//         for(int i = 0 ; i < n ; i++){
//             dp.add(new ArrayList<>());
//         }

//         dp.get(0).add(triangle[0][0]);


        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j <= i ; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else{
                    // dp[1][0] + triangle[2][1];
                    // dp[1][1] + triangle[2][1];
                    int a = dp[i-1][j-1] + triangle[i][j];
                    int b = dp[i-1][j] + triangle[i][j];
                    if (a > b) dp[i][j] = a;
                    else dp[i][j] = b;
                }
            }
        }

        int max = -1;

//         for (int i = 0 ; i < n ; i++){
//             for (int j = 0 ; j <= i ; j++){
//                 System.out.print(dp[i][j]);
//                 System.out.print(" ");
//             }
//             System.out.println();
//         }

        for (int i = 0 ; i < n ; i++){
            if(max < dp[n-1][i]) max = dp[n-1][i];
        }


        return max;
    }
}

/*
dp[i][j] = i번째 레벨에서의 최대합
dp[i][j] = dp[i-1][j] + triangle[i][j] vs dp[i-1][j+1] + triangle[i][j] (양 끝값처리만 해주고)
dp[n]에서 최대값 찾으면 될듯?

*/