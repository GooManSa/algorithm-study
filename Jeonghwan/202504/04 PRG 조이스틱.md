```
class Solution {
    public int solution(String name) {

        int len = name.length();

        int answer = 0;
        int minDis = 999999;
        int switchCount = 0;


        boolean allA = true;
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) != 'A') allA = false;
        }
        if (allA) return 0;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);

            int cnt = Math.min(c - 'A', 'Z' - c + 1);
            switchCount += cnt;

            if (c == 'A') continue;
            int minCur = Math.min(i, len - i);

            // A가 아닌 제일 가까운 위치 (왼쪽으로 이동거리)
            int r = 1;
            while (r < len && name.charAt((i + r) % len) == 'A') { r++; }
            minDis = Math.min(minDis, minCur + len - r);

            // A가 아닌 제일 먼 위치 (오른쪽으로 이동거리)
            int l = 1;
            while (l < len && name.charAt((len + i - l) % len) == 'A') { l++; }
            minDis = Math.min(minDis, minCur + len - l);
        }

        answer = minDis + switchCount;

        return answer;
    }
}
```
