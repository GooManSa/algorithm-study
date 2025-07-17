```java
import java.util.*;
import java.io.*;

public class Main {

    public static int lowerBound(int[][] array, int target) {
        int l = 0;
        int r = array.length - 1;

        int answer = array.length;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            if (array[mid][1] < target) {
                l = mid + 1;
            } else {
                answer = mid;
                r = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 보석의 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 보석의 가치
        }
        Arrays.sort(jewels, (a, b) -> a[0] - b[0]); // 무게가 가벼운 순으로 정렬

        List<Integer> capacities = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            capacities.add(Integer.parseInt(br.readLine()));
        }
        capacities.sort(Comparator.naturalOrder());

        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        for (int cap : capacities) {
            while (idx < N && jewels[idx][0] <= cap) { // 보석의 무게가 가방의 용량보다 작으면
                pq.add(jewels[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}

```
