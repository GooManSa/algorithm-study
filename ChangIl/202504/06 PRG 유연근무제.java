class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = n;

        for (int i = 0 ; i < n ; i++){

            int limitTime;

            if ((schedules[i] + 10)%100 >= 60){
                limitTime = schedules[i] + 100 - 60 + 10;
            }
            else {
                limitTime = schedules[i] + 10;
            }

            for (int j = 0 ; j < 7 ; j++){
                int day = (startday + j) % 7;
                if (day == 6 || day == 0){
                    continue;
                }
                if (timelogs[i][j] > limitTime){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}

/*
# schedules[i] = i+1번째 직원이 설정한 출근 희망 시간
# timelogs[i][j] = i+1번째 직원이 j+1일차에 출근한 시각
# startday = 이벤트를 시작한 요일을 의미하는 정수
# 출근 희망 시각과 실제로 출근한 시각을 100으로 나눈 나머지는 59 이하 (분 모듈러)
# 토, 일은 출근시각 의미없음


# 직원별로 각 날짜를 순회(이게 낫겠다)
# 토, 일은 제외
# 만점에서 count -= 1 하기
 */