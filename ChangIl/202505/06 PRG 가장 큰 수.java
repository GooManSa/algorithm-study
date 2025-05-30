import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String answer = "";
        String[] strings = new String[numbers.length];

        // 문자 배열로 전환
        for (int i = 0 ; i < numbers.length ; i++ ){
            strings[i] = String.valueOf(numbers[i]);
        }

        // comparator 구현체 전달
        Arrays.sort(strings, new sComparator());

        // "가장 큰 수" 엣지케이스
        if (strings[0].equals("0")){
            return "0";
        }

        // python과 join 용법이 조금 다름
        return String.join("",strings);
    }

    public class sComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2){

            // 더 큰 수는 이어붙였을때 더 큰수가 되면 됨
            String s1 = o1 + o2;
            String s2 = o2 + o1;

            // 더 큰수는 문자열 아스키 코드에서도 더 큰 값
            return s2.compareTo(s1);
        }

    }


}