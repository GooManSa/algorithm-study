```
class Solution {

    public String solution(String number, int k) {
        String answer = "";

        // 총 자릿 수 n
        int len = number.length();
        int n = len - k;

        StringBuilder newString = new StringBuilder(number.substring(len - n));

        for (int i = len - n - 1; i >= 0 ; i--) { // 역순으로 진행
            char c = number.charAt(i);
            char replace = c;
            int idx = 0;
            while (idx < newString.length() && replace >= newString.charAt(idx)) {
                char tmp = newString.charAt(idx);
                newString.setCharAt(idx, replace);
                replace = tmp;
                idx++;
            }
        }

        answer = newString.toString();

        return answer;
    }
}
```
