```java
class Solution {
    String answer = "";
    int l = 10; // *
    int r = 12; // #

    private void touch(int tar, String hand) {
        if (hand.equals("L")) {
            l = tar;
            answer += "L";
        } else {
            r = tar;
            answer += "R";
        }
    }

    private int getGap(int num1, int num2) {
        int rGap = Math.abs((num1 - 1) / 3 - (num2 - 1) / 3);
        int cGap = Math.abs((num1 - 1) % 3 - (num2 - 1) % 3);

        return rGap + cGap;
    }

    public String solution(int[] numbers, String hand) {

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i] == 0? 11: numbers[i]; // 0을 위치 번호로 변환
            if (num == 1 ||  num == 4 || num == 7) {
                touch(num, "L");
            } else if (num == 3 ||  num == 6 || num == 9) {
                touch(num, "R");
            } else {
                int ld = getGap(num, l);
                int rd = getGap(num, r);

                if (ld == rd) {
                    if (hand.equals("right")) {
                        touch(num, "R");
                    } else {
                        touch(num, "L");
                    }
                } else if (ld < rd) {
                    touch(num, "L");
                } else {
                    touch(num, "R");
                }
            }
        }
        return answer;
    }
}
```
