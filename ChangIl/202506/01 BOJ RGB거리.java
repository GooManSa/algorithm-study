import java.util.*;
import java.io.*;
import java.lang.Math;

class Main{
    public static int solution(int n, int[][] arr){

        int[][] dp = new int[n][3];

        for (int i = 1 ; i < n ; i++){
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }

        Arrays.sort(arr[n-1]);
        return(arr[n-1][0]);
    }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];


        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));

    }
}

/*

집 N
거리 선분
빨, 초, 파 (각 집마다 비용있음)

1번집 != 2번집
N번집 != N-1번집
i번집은 양옆에 같으면 안됨


dpw[i][3] = 현재까지 비용의 최소값인데, 0 선택했을때, 1 선택했을때, 2 선택했을때
dpc[i] = 현재 집의 컬러
dpc[i] = dp[i-1]

걍 다구하기? 제약조건 생각보다 괜찮음

 */