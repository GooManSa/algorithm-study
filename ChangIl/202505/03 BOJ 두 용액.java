import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] liq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++){
            liq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liq);

        int min = 2000000000;
        int first = 0;
        int second = 0;
        int start = 0;
        int end = n-1;

        while(start < end){
            int cur = liq[start] + liq[end];
            int absCur = 0;
            if (cur < 0){
                absCur = cur * -1;
            }else {
                absCur = cur;
            }
            if (absCur < min){
                min = absCur;
                first = start;
                second = end;
                if (min == 0){
                    break;
                }
            }
            if (cur < 0){
                start += 1;
            }
            else{
                end -= 1;
            }
        }

        System.out.println(liq[first] + " " + liq[second]);

    }
}

/*
산성 용액 : 1부터 10억까지 양의 정수
알칼리성 : -1부터 -10억

같은 양의 두 용액 합성해서 0에 가장 가까운 혼합 용액 만들기 해야함

n^2으로 해버리면 시간초과 나려나? 10만 * 10만이니까 100억인데 시간초과 나겠다

 */