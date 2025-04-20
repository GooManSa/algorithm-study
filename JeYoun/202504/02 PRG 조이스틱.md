```java
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;
        
        char[] nameArr = name.toCharArray();
        for(int i = 0; i < len; i++){
            char c = nameArr[i];
            answer += Math.min( c - 'A' , 'Z' - c + 1);
            
            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && nameArr[next] == 65){
                next++;
            }
            
            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, i * 2 + (len - next));
            move = Math.min(move, (len - next) * 2 + i);
        }
        answer += move;
        return answer;
    }
}

```