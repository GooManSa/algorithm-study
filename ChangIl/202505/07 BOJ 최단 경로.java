import java.util.*;
import java.io.*;

class Main{

    static class Node implements Comparable<Node>{
        int x;
        int w;

        Node(int x, int w){
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());

//        Scanner sc = new Scanner(System.in);
//        int v,e,s;
//        v = sc.nextInt();
//        e = sc.nextInt();
//        s = sc.nextInt();

        //인접 행렬 방식 -> v와 e가 크다면, 하지만 sparse하다면 공간복잡도 초과가능
//        int[][] graph = new int[v+1][v+1];
//        for (int i = 0 ; i<= v; i++) {
//            Arrays.fill(graph[i], -1);
//        }

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= v ; i++){
            graph.add(new ArrayList<>());
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean[] visited = new boolean[v+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();


        for (int i = 1; i <= e ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//            int x,y,w;
//            x = sc.nextInt();
//            y = sc.nextInt();
//            w = sc.nextInt();
            graph.get(x).add(new Node(y,w));
        }

        // 시작점 초기화
        pq.add(new Node(s,0));
        dist[s] = 0;

        while(!pq.isEmpty()){
            Node node = pq.remove();

            if (visited[node.x]) continue;
            visited[node.x] = true;

            //인접 행렬일떄
//            for(int i = 1 ; i < v+1 ; i++){
//                int cur = graph[node.x][i];
//                if (cur != -1){
//                    if(dist[i] > dist[node.x] + cur){
//                        dist[i] = dist[node.x] + cur;
//                        pq.add(new Node(i, dist[i]));
//                    }
//                }
//            }

            //인접 리스트일때
            for (Node next : graph.get(node.x)){
                if(dist[next.x] > dist[node.x] + next.w){
                    dist[next.x] = dist[node.x] + next.w;
                    pq.add(new Node(next.x, dist[next.x]));
                }
            }
        }

        for (int i = 1 ; i < v+1 ; i++){
            if (dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}