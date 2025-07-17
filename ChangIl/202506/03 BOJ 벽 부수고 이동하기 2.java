import java.io.*;
import java.util.*;

class Main{

    static class Node{
        int x,y;
        int count;
        int answer;

        Node(int x, int y, int count, int answer){
            this.x = x;
            this.y = y;
            this.count = count;
            this.answer = answer;
        }

    }


    public static int bfs(int n, int m, int k, int[][] map){

        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int[][][] visited = new int[n][m][k+1];

        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(0,0,0,1));
        visited[0][0][0] = 1;

        while(!deque.isEmpty()){
            Node node = deque.remove();

            if (node.x == n-1 && node.y == m-1){
                return node.answer;
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = dir[i][0] + node.x;
                int ny = dir[i][1] + node.y;

                if (nx >= n || ny >= m || nx < 0 || ny < 0){
                    continue;
                }

                if (map[nx][ny] == 0 && visited[nx][ny][node.count] == 0) {
                    deque.add(new Node(nx, ny, node.count, node.answer + 1));
                    visited[nx][ny][node.count] = 1;
                } else if (map[nx][ny] == 1 && node.count < k && visited[nx][ny][node.count + 1] == 0) {
                    deque.add(new Node(nx, ny, node.count + 1, node.answer + 1));
                    visited[nx][ny][node.count + 1] = 1;
                }
            }
        }
        return -1;

    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m,k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];


        for (int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for (int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        System.out.println(bfs(n,m,k,map));
    }
}