import java.util.*;

class Main {

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] answer = new int[N];
        int[][] arr = new int[N][2];
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0 ; i < N ; i++){
            int w = arr[i][0];
            int h = arr[i][1];
            int cnt = 0;
            for (int j = 0 ; j < N ; j++){
                int cw = arr[j][0];
                int ch = arr[j][1];
                if (cw > w && ch > h){
                    cnt++;
                }
            }
            answer[i] = cnt+1;
        }

        for (int i = 0 ; i < N ; i++){
            System.out.print(answer[i] + " ");
        }
        return 0;
    }

    public static void main(String[] args) {
        solution();
    }
}

/*
덩치가 더 큰 기준 -> 키, 몸무게 둘다 커야함
현재 자신의 rank 아는 방법 -> 자신보다 큰 덩치의 사람이 k명일 경우
완전탐색? -> n^2 이지만 n의 최대범위 50 (2500)
 */