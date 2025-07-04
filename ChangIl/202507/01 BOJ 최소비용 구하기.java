import java.io.*;
import java.util.*;

class Main{

    static class Node implements Comparable<Node>{
        int x,w;

        Node(int x, int w){
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }


    public static void main(String[] args) throws IOException{

        List<List<Node>> graph = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u, v, w;
            StringTokenizer st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        int x,y;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[x] = 0;
        boolean[] visited = new boolean[n+1];
        pq.add(new Node(x,0));

        while(!pq.isEmpty()){
            Node node = pq.remove();

            // visited 배열 대신 이렇게 검사해도 문제없음 (PriorityQueue의 특성상)
            if (dist[node.x] < node.w) continue;

            for(Node nextNode : graph.get(node.x)){
                if(dist[nextNode.x] > dist[node.x] + nextNode.w){
                    dist[nextNode.x] = dist[node.x] + nextNode.w;
                    pq.add(new Node(nextNode.x, dist[nextNode.x]));
                }
            }
        }

        System.out.println(dist[y]);




    }
}



// 무슨 문제냐면, 비용이 있는 그래프에서 출발 지점에서 도착지점까지 가는 최소 비용을 출력하는 문제
/*
방향이 있고, 가중치가 있는 그래프 탐색 문제

가중치가 있는 순간, BFS나 DFS는 사용할 수 없고, 간선 기준이나 정점 기준의
그래프 탐색 선택해야함

정점의 갯수 < 1000
간선의 갯수 < 100000

하나의 정점에서, 특정 정점까지의 최소 비용을 파악하는 문제이므로 다익스트라 알고리즘 사용
(음의 가중치 없는 그래프에서 최단 경로 구하기)

경로 구하고싶으면 Path 배열 만들어서 이전 정점을 저장하도록 (dist update하는 경우)
 */