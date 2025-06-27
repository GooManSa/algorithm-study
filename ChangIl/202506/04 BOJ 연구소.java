import java.io.*;
import java.util.*;

class Main {

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void bfs(int[][] map, List<Node> virusList, int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        for (Node v : virusList) {
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int[] d : dir) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static int countSafe(int[][] map, int n, int m) {
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<Node> virusList = new ArrayList<>();
        List<int[]> emptyList = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virusList.add(new Node(i, j));
                else if (map[i][j] == 0) emptyList.add(new int[]{i, j});
            }
        }

        int maxSafe = 0;
        int size = emptyList.size();

        // 모든 벽 3개 조합
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int[][] temp = new int[n][m];
                    for (int r = 0 ; r < n ; r++) {
                        temp[r] = Arrays.copyOf(map[r], m);
                    }

                    // 벽 3개 세우기
                    int[] a = emptyList.get(i);
                    int[] b = emptyList.get(j);
                    int[] c = emptyList.get(k);
                    temp[a[0]][a[1]] = 1;
                    temp[b[0]][b[1]] = 1;
                    temp[c[0]][c[1]] = 1;

                    bfs(temp, virusList, n, m);

                    // 안전구역 세기
                    maxSafe = Math.max(maxSafe, countSafe(temp, n, m));
                }
            }
        }

        System.out.println(maxSafe);
    }
}


/*
모든 2로부터 방문해서, visited되지 않은 영역을 찾는 문제
벽을 3개 꼭 세워야 함.

벽을 세워서 이득을 보려면, 바이러스 근처에 세워서 특정 바이러스가 더이상 퍼져나가지 못하게 하면 됨

1. 안전 영역을 최대로 한다는 것은, 특정 바이러스(1,2,3)가 아예 원천 봉쇄되는 경우를 찾는 것
- 원천 봉쇄가 아닌, 중간 차단으로 (일부 퍼지게 나둔 후) 더 이득을 볼 수 있는 경우가 존재하는가?
- 즉 1이 최적해인가?
- 그렇다. 그러나 특정 공간에 바이러스가 두개 이상 존재하는 경우, 세개 이상 존재하는 경우도 포함해야한다.

2. 2가 포함된 인덱스로부터, 공간을 모두 순회.
- 공간에 다른 2(바이러스)가 없다면, 그 공간의 크기 (size) 와 바이러스 원천 차단할 수 있는 벽의 갯수를 리턴
- 공간에 다른 2(바이러스)가 2~3개 있다면,
    - 벽의 갯수 3개 이하로 원천 차단이 가능하다면, 공간의 크기와 벽 갯수 리턴
    - 벽갯수 3개 이하로 원천차단 불가능할 경우, 그 공간 포기
- 공간에 다른 2(바이러스)가 4개 이상 있다면, 그 공간은 원천차단이 불가능


---> n : 3, m : 8 이라 naive하게 접근해도 풀리는 문제이다.

필요한것
method wallNeeds()
method graphTraversal()
 */