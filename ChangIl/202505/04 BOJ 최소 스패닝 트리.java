import java.io.*;
import java.util.*;

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
        if (parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int a, int b){
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB){
            parent[rootB] = rootA;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge> tree = new ArrayList<>();

        for (int i = 0; i < e; i++){
            int x,y,w;
            x = sc.nextInt();
            y = sc.nextInt();
            w = sc.nextInt();
            tree.add(new Edge(x,y,w));
        }
        Collections.sort(tree);

        int[] parent = new int[v+1];
        for (int i = 1; i <= v; i++) parent[i] = i;

        int mstWeight = 0;
        int count = 0;

        for (Edge edge : tree){
            if (find(parent, edge.from) != find(parent, edge.to)){
                union(parent, edge.from, edge.to);
                mstWeight += edge.weight;
                count++;
                if(count == v - 1) break;
            }
        }

        System.out.println(mstWeight);



//        Set<Integers> roots = new HashSet<>();
//        for (int i = 0; i < n; i++){
//            roots.add(find(parent, i));
//        }
//        return roots.size();

    }


    /*
    A,B 의 가중치 1
    양방향이



     */
}