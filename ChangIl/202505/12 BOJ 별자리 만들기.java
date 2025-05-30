import java.io.*;
import java.util.*;
import java.lang.Math;

class Main{

    static class Edge implements Comparable<Edge>{
        int v,w;
        float weight;

        Edge(int v, int w, float weight){
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return Float.compare(weight,e.weight);
        }
    }

    static int find(int[] parent, int x){
        if(x != parent[x]){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    static int union(int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB){
            parent[rootA] = rootB;
        }
        else{
            return 1;
        }
        return 0;
    }


    static float calculateDistance(float x1, float y1, float x2, float y2){
        return (float)Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        float[][] arr = new float[n][2];

        for (int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Float.parseFloat(st.nextToken());
            arr[i][1] = Float.parseFloat(st.nextToken());
        }

        List<Edge> edgeList = new ArrayList<>();


        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if(i == j){ continue; }
                edgeList.add(new Edge(i,j,calculateDistance(arr[i][0],arr[i][1],arr[j][0],arr[j][1])));
            }
        }

        Collections.sort(edgeList);

        int[] parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        float answer = 0;

        for (int i = 0 ; i < edgeList.size() ; i++){
            int v = edgeList.get(i).v;
            int w = edgeList.get(i).w;
            float weight = edgeList.get(i).weight;

//            System.out.println(edgeList.get(i).weight);
            if(union(parent,v,w) == 0){
                answer += weight;
            }

        }

        System.out.println(answer);



    }
}





/*
n개의 별들을 이어 별자리 하나 만들기
* 별자리 이루는 선은 서로 다른 두 별을 일직선으로 이은 형태이다.
* 모든 별들은 별자리 위의 선을 통해 서로 직/간접 이어져야 함

최소 비용 구하기 -> MST 문제
MST 문제면, Kruskal or Prim
주어지는 input : 별들의 좌표
근데 보통의 MST와 다르게, edge가 주어지지 않음. Dijkstra는 가중치가 있는 간선 그래프고
가장 최소 비용 선을 항상 greedy하게 구하는 MST가 더 맞겠다.

점과 점 사이 거리 구하는 공식하나
kruskal로 가장 가까운 점을 고르고, Union-find로 cycle형성이 되는지 확인하고, 최소거리 업데이트하고
visited도 check하고 방문했는지 확인하기
보통 prim이나 kruskal은 연결가능한 정점을 파악하고, 간선을 정렬하고, greedy하게 접근하는데 여기서 100*100 그래프를 미리 만들어버린다?
 */