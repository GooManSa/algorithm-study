import java.io.*;
import java.util.*;



class Main{

    static class Node{
        int x,y,count;
        boolean hasUsed;


        Node(int x, int y, int count, boolean hasUsed){
            this.x = x;
            this.y = y;
            this.hasUsed = hasUsed;
            this.count = count;
        }
    }

    public static int bfs(int[][] gameMap, int n , int m){

        int[][] dir =  {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][][] visited = new int[n][m][2];
        visited[0][0][0] = 1;

        int answer = Integer.MAX_VALUE;

        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(0,0,1,false));
        while(!deque.isEmpty()){
            Node node = deque.remove();
            if (node.x == n-1 && node.y == m-1){
                return node.count;
            }
            for(int i = 0; i < 4 ; i++){
                int nx = dir[i][0] + node.x;
                int ny = dir[i][1] + node.y;
                if(nx < 0 || ny < 0 || nx > n-1 || ny > m-1) { continue; }
                if(gameMap[nx][ny] == 0){
                    if(node.hasUsed == true){
                        if(visited[nx][ny][0] == 0 && visited[nx][ny][1] == 0){
                            deque.add(new Node(nx,ny,node.count+1,true));
                            visited[nx][ny][1] = 1;
                        }
                    } else{
                        if(visited[nx][ny][0] == 0){
                            deque.add(new Node(nx,ny,node.count+1,false));
                            visited[nx][ny][0] = 1;
                        }
                    }
                }else{
                    if(node.hasUsed == false && visited[nx][ny][0] == 0){
                        deque.add(new Node(nx,ny,node.count+1,true));
                        visited[nx][ny][1] = 1;
                    }
                }

            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] gameMap = new int[n][m];

        for (int i = 0 ; i < n ; i++){
            String str = (br.readLine());
            for (int j = 0 ; j < m ; j++){
                gameMap[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(gameMap,n,m));
    }
}


/*
다음 이동 가능한 노드를 상하좌우 및 벽깨기까지 5개의 방향이 있다고 가정하는건 어떨까

그렇게 가정했을때 벽 깨기 상태는 어떻게 저장?
1. 전역변수로 저장
2. 벽 깰수있는 상태도 큐에 담아서 전달

1. 전역변수로 저장했을때, 상태 관리가 너무 힘듬.
2. 벽 깰수있는 상태를 큐에 담아서 전달하면, 현재 index에서 독립적으로 판단가능
2-1. 벽을 깨고 방문한 곳은 visited check를 2로 저장해서 visited 2면 방문할 수 있도록 하기
2-2. 즉 gamemap[nx][ny] = 0 or 2라면 gamemap[nx][ny]로 방문 가능 (이때는 gamemap[nx][ny] = 1로 변경하기)
2-3. gamemap[nx][ny] = 1 이고 hasUsed = false라면 gamemap[nx][ny] = 2로 설정하고 hasUsed = true로 변경
2-*. gamemap 자체를 visited 처리해버리면 bfs 경로중 다른 가지에서의 상태 변경이 또다른 가지의 상태에 영향을 주기에, visited 배열을 따로 사용하자

*. 벽을 깼을때와 깨지 않았을때의 상태는 전혀 다른 상태. 전혀 다른 gameMap이 됨을 인지해야함. 벽을 깬지, 안깬지의 방문했는지 안했는지를 확인함으로써 구분
 */

