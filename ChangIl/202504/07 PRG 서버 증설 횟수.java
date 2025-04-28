class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];

        for (int i = 0 ; i<24 ; i++){

            int player = players[i];
            int currentServer = 0;
            int startIdx = 0;

            if(i>=k){startIdx = i-k+1;}

            for(int j = startIdx ; j < i ; j++){
                currentServer += server[j];
            }

            if (player < m){
                continue;
            } else if(player > currentServer * m){
                int demand = (player / m) - currentServer;
                server[i] = demand;
                answer += demand;
            }
        }
        return answer;
    }
}

/*

### 같은 시간대에 m명 늘어나면 서버 1대
# 어느 시간대 사용자 m명 미만, 서버 증설 필요 x
# 어느 시간대 사용자 nxm < x < (n+1) x m 이면 최소 n대서버 운영중
# 한번의 서버는 k 시간동안 운영, 그 이후에는 반납

# 서버의 증설시간, 소멸시간 체크
# 시간대의 사용자 인원 체크

# 주어지는 것 -> 각 시간대의 동접자 (총 24번 순회가 최대)
# 시작할땐 서버 0대

# 알아야 하는것 최소 서버 증설 횟수

# 해결방법 :
# 1. 24를 순회하며, 현재 필요한 서버 개수를 파악
# 2. 현재 가동중인 서버보다 많이 필요하면 몇개 증설
# 2-1. 현재 가동중인 서버 파악 : 현재시간 t라하면 server[t-k:t]까지의 원소합 구하기
# 3. 현재 시간대에 끝나는 서버 종료

# 서버의 증설시간과 소멸시간을 어떻게 파악(추적)할 것인가?
# 배열로 server[3] 은 3시에 증설된 서버의 갯수 이렇게만 해도 될듯?

# 시작 인덱스가 t-k가 아닌 t-k+1임..
*/