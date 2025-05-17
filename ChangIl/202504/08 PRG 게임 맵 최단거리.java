import java.util.*;

class Solution {
    class Node{
        int x;
        int y;
        Node(int x, int y) {
        this.x = x;
        this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int n = maps.length;
        int m = maps[0].length;

        int[][] visited = new int[n][m];

        Deque<Node> deque = new ArrayDeque<>();

        deque.add(new Node(0,0));
        visited[0][0] = 1;

        while(deque.size()>0){
            Node curNode = deque.remove();
            int x = curNode.x;
            int y = curNode.y;

            for(int i = 0 ; i < 4 ; i++ ){
                int nextX = dx[i] + x;
                int nextY = dy[i] + y;
                if ((nextX < n && nextY < m && nextX >= 0 && nextY >= 0) && visited[nextX][nextY] == 0 && maps[nextX][nextY] == 1){
                    deque.add(new Node(nextX,nextY));
                    visited[nextX][nextY] = visited[x][y] + 1;
                }
            }
        }

        return visited[n-1][m-1] != 0 ? visited[n-1][m-1] : -1;
    }
}