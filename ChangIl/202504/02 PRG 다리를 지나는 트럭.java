import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 무게 + 들어온 시간의 Deque
        Deque<int[]> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int currentIdx = 0;

        while (true) {
            time++;

            // 나갈 트럭 내보내기
            if (!bridge.isEmpty() && time - bridge.peekFirst()[1] >= bridge_length) {
                int[] truck = bridge.pollFirst();
                totalWeight -= truck[0];
            }

            // 들어올 트럭 들여보내기
            if (currentIdx < truck_weights.length && totalWeight + truck_weights[currentIdx] <= weight) {
                bridge.offerLast(new int[]{truck_weights[currentIdx], time});
                totalWeight += truck_weights[currentIdx];
                currentIdx++;
            }

            // 대기 트럭 없고, 다리도 비었다면 종료하기
            if (currentIdx == truck_weights.length && bridge.isEmpty()) {
                break;
            }
        }

        return time;
    }
}
