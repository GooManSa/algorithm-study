import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        int top = 0;
        for (int i : arr){
            if (top == 0){
                answer.add(i);
                top += 1;
            }
            else {
                if(answer.get(top) != i){
                    answer.add(i);
                    top += 1;
                }
            }
        }


        return answer;
    }
}