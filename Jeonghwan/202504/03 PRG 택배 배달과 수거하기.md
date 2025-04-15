```
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    Deque<Integer> delQue;
    Deque<Integer> pickQue;

    private void deliver(int cap) {
        int delCap = cap;
        int pickCap = cap;

        // 거리가 먼 곳부터 배달, 배달할 물건이 없으면 deque에서 제거
        while (!delQue.isEmpty() && (delCap > 0 || delQue.peekLast() == 0)) {
            int last = delQue.pollLast();
            int val = Math.min(last, delCap);
            delCap -= val;
            if (last != val)
                delQue.offerLast(last - val);
        }
        // 거리가 먼 곳부터 회수, 회수할 물건이 없으면 deque에서 제거
        while (!pickQue.isEmpty() && (pickCap > 0 || pickQue.peekLast() == 0)) {
            int last = pickQue.pollLast();
            int val = Math.min(last, pickCap);
            pickCap -= val;
            if (last != val)
                pickQue.offerLast(last - val);
        }
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        delQue = new LinkedList<Integer>(Arrays.stream(deliveries)
                                             .boxed()
                                             .collect(Collectors.toList()));
        pickQue = new LinkedList<Integer>(Arrays.stream(pickups)
                                             .boxed()
                                             .collect(Collectors.toList()));

        // 배열 마지막에 배달,회수할 물건이 0이면 제거해줘야함
        deliver(0);

        long answer = 0;
        while (!delQue.isEmpty() || !pickQue.isEmpty()) {
            // 배달 또는 회수할 물건이 있는 목적지 중 더 먼곳을 기준으로 이동거리 추가(왕복이기 때문에 2배)
            answer += Math.max(delQue.size(), pickQue.size()) * 2;
            pop(cap);
        }

        return answer;
    }
}
```
