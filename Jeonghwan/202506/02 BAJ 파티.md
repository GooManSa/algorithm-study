```java
import java.util.*;
import java.io.*;

// 파티장소에서 돌아가는데 걸리는 시간 -> 다익스트라
// 파티장소로 오는데 걸리는 시간 -> 역방향 그래프 + 다익스트라

public class Main {

    public static int[] dijkstra(int n, int start, Map<Integer, List<int[]>> edges) {
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        costs[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] head = pq.poll();

            int node = head[0];
            int weight = head[1];

            for (int[] edge : edges.getOrDefault(node, Collections.emptyList())) {
                int nx = edge[0];
                int cost = edge[1];
                if (costs[nx] > weight + cost) {
                    costs[nx] = weight + cost;
                    pq.add(new int[]{nx, weight + cost});
                }
            }
        }

        return costs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Map<Integer, List<int[]>> edges = new HashMap<>();
        Map<Integer, List<int[]>> reverse = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            edges
                .computeIfAbsent(s, k -> new ArrayList<>())
                .add(new int[]{e, w});
            reverse
                .computeIfAbsent(e, k -> new ArrayList<>())
                .add(new int[]{s, w});
        }

        // 파티장소 -> 각자 마을 : 다익스트라
        int[] fromX = dijkstra(N, X - 1, edges);

        // 각자 마을 -> 파티장소 : 역방향 그래프 + 다익스트라
        int[] toX = dijkstra(N, X - 1, reverse);

        int answer = 0;
        for (int i = 0; i < N; i++){
            int sum = fromX[i] + toX[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}

```
