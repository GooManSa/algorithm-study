import java.util.*;

class Solution {

    class Node implements Comparable<Node>{
        int edge;
        int cost;

        Node(int edge,int cost){
            this.edge = edge;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }

    public int solution(int n, int[][] costs) {

        int totalWeight = 0;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // 그래프 구성
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int weight = cost[2];

            graph.get(a).add(new Node(b,weight));
            graph.get(b).add(new Node(a,weight));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (visited[node.edge]) continue;
            totalWeight += node.cost;
            visited[node.edge] = true;

            for (Node subNode : graph.get(node.edge)){
                pq.add(subNode);
            }
        }
        return totalWeight;
    }
}



/*
문제 : 모든 섬이 서로 통행 가능하도록 만들어야함
조건 : 섬과 섬 사이에 다리 건설 비용이 주어짐
구하고자 하는 것 : 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들기

접근 : Prim




*/