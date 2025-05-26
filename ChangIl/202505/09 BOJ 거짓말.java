import java.util.*;
import java.io.*;

class Main{

    public static int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(boolean[] truth, int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB){
            if (truth[rootA] == true){
                parent[rootB] = rootA;
            }
            else {
                parent[rootA] = rootB;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        boolean[] truth = new boolean[n+1];
        int[] parent = new int[n+1];


        // 2차원 ArrayList
        List<List<Integer>> party = new ArrayList<>();
        for(int i = 0; i<m ; i++){
            party.add(new ArrayList<>());
        }

        // parent 초기화
        for(int i = 0; i<=n ; i++){
            parent[i] = i;
        }

        for (int i = 0; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = 0;
            if (i == 0){
                for (int j = 0; j < k ; j++){
                    t = Integer.parseInt(st.nextToken());
                    truth[t] = true;
                }
            } else {
                for (int j = 0; j < k; j++) {
                    t = Integer.parseInt(st.nextToken());
                    party.get(i-1).add(t);
                }
            }
        }

        for (List<Integer> arr : party){
            if (arr.size() >= 2){
                for (int i = 0 ; i < arr.size()-1 ; i++){
                    union(truth, parent, arr.get(i), arr.get(i+1));
                }
            }
        }

        // 각 파티 판별
        int count = 0;
        for (List<Integer> arr : party){
            boolean canLie = true;
            for (int p : arr){
                int root = find(parent, p);
                if (truth[root]){
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);







    }
}


/*
사람수 N, 파티수 M
이야기 진실 아는 사람수 & 번호 (1~N)
각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어짐

그니까 1~N이 속한 파티에 참가한 사람이라면, 다음번에도 진실을 구별할 수 있음
1~M의 파티 참석 명단을 전부 순회하면서, union-find하고 root 최신화하고, 다시 party 순회하면서 find해서 아닌 party찾기

 */