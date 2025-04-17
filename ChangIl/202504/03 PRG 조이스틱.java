public class Solution {
    public int solution(String name) {
        int length = name.length();
        int count = 0;
        int answer = 0;

        // 상하 이동값 구하기
        for (int i = 0 ; i < length ; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        // 좌우 이동값 구하기 (최대값 : 오른쪽 끝까지 쭉 가는 경우)
        // 한 방향으로 이동하다 꺾는 최대 횟수는 1 (2 이상부턴 지나갔던 구간을 또 지나는 경우와 동일하므로)
        // 가장 큰 A가 연속된 범위만 피하면 됨.
        // A가 시작되는 인덱스까지 갔다가 뒤로 돌아가기 vs A가 끝나는 인덱스까지 뒤로 갔다 다시 앞으로 가기
        int minMove = length - 1;
        for (int currentIdx = 0; currentIdx < length; currentIdx++){

            int nextIdx = currentIdx+1;
            while (nextIdx < length && name.charAt(nextIdx) == 'A'){
                nextIdx++;
            }
            // currentIdx -> 0부터 A시작되는 인덱스까지
            // (length - nextIdx) -> 마지막부터 A 끝나는 인덱스까지
            int move = currentIdx + length - nextIdx + Math.min(currentIdx, length - nextIdx);
            minMove = Math.min(minMove, move);


        }

        return answer + minMove;

    }

}




// 그리디가 최적해를 보장하지 않음
// 반례 : 멀리 떨어진 문자(끝에 있는 B)를 먼저 처리하면, 전체 커서 이동을 줄일 수 있는 경우
// ex) "BBBAAAAAB"
//public class Solution {
//    public int solution(String name) {
//        int length = name.length();
//        int count = 0;
//        boolean[] visited = new boolean[length];
//        int answer = 0;
//
//        for(int i = 0 ; i < length ; i++){
//            if (name.charAt(i) != 'A'){
//                count++;
//            }
//        }
//
//
//        int currentIdx = 0;
//
//        while(count > 0){
//
//            // 현재 index의 위아래 count 계산 및 count 차감
//            char currentChar = name.charAt(currentIdx);
//            if (currentChar!='A' && !visited[currentIdx]){
//                answer += Math.min(currentChar - 'A', 'Z'-currentChar+1);
//                visited[currentIdx] = true;
//                count--;
//            }
//
//            if (count <= 0){
//                break;
//            }
//
//            // 다음 index 계산 (좌우 이동)
//            for (int i = 1; i<length ; i++){
//                int right = (currentIdx + i) % length;
//                int left = (length + currentIdx - i) % length;
//
//
//                if (name.charAt(right) != 'A' && !visited[right]){
//                    answer += i;
//                    currentIdx = right;
//                    break;
//                }
//
//                if (name.charAt(left) != 'A' && !visited[left]){
//                    answer += i;
//                    currentIdx = left;
//                    break;
//                }
//            }
//
//
//        }
//
//        return answer;
//
//    }
//
//}
