```java
import java.util.*;
import java.lang.*;
import java.io.*;


class Point implements Comparable<Point>{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}
// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x,y));
        }

        Collections.sort(points);
        for(Point p : points) System.out.println(p.x + " " + p.y);
    }
}
```