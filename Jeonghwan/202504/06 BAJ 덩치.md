```java
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            list.add(new int[]{w, h});
        }

        // System.out.println("parse done");

        for (int[] wh: list) {
            int cnt = 1;
            int w1 = wh[0];
            int h1 = wh[1];

            for (int[] wh2 : list) {
                int w2 = wh2[0];
                int h2 = wh2[1];
                if (w1 < w2 && h1 < h2) {
                    cnt++;
                }
            }
            System.out.printf("%d ", cnt);
        }
    }
}
```
