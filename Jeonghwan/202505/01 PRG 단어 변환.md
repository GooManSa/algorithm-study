```java
import java.util.*;

// 일종의 그래프
// 각 words는 노드, 글자 한개만 다른 words간 간선이 있는 구조
// 완전탐색을 통해서 begin 출발지 -> target 도착지로 이동가능한 경로의 최단거리

class Solution {

    private int diff(String s1, String s2) {
        int cnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }

        return cnt;
    }

    private int find(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (s == words[i]) {
                return i;
            }
        }
        return -1;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;

        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String left = words[i];
                String right = words[j];
                if (diff(left, right) == 1) {
                    edges.computeIfAbsent(i+1, k -> new ArrayList<Integer>()).add(j+1);
                    edges.computeIfAbsent(j+1, k -> new ArrayList<Integer>()).add(i+1);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (diff(begin, words[i]) == 1) {
                edges.computeIfAbsent(0, k -> new ArrayList<Integer>()).add(i+1);
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        int[] vt = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            vt[i] = 999999;
        }

        q.add(0);
        vt[0] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 가장 빨리 도착하면 최단거리
            if (cur > 0 && words[cur-1].equals(target)) {
                return vt[cur];
            }

            List<Integer> nxs = edges.get(cur);
            if (nxs != null) {
                for (Integer nx: nxs) {
                    if (vt[nx] > vt[cur]+1) {
                        vt[nx] = vt[cur]+1;
                        q.add(nx);
                    }
                }
            }
        }

        return 0;
    }
}
```
