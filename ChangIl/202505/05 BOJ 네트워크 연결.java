import java.util.*;
import java.io.*;

class Main{

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }

    public static int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent,parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int from, int to){
        int a = find(parent, from);
        int b = find(parent, to);
        if (a != b){
            parent[a] = parent[b];
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            edges.add(new Edge(a,b,c));
        }
        Collections.sort(edges);

        int[] parents = new int[n+1];
        for (int i = 1; i < n+1; i++){
            parents[i] = i;
        }

        int treeWeight = 0;
        int count = 0;

        for(Edge edge : edges){
            if (find(parents, edge.from) != find(parents, edge.to)){
                union(parents, edge.from, edge.to);
                count++;
                treeWeight += edge.weight;
                if (count == n-1) break;
            }
        }

        System.out.println(treeWeight);

    }


}