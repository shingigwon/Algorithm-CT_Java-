class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];

        for(int i=0; i<players.length; i++){
            int player = players[i];
            if(player<m) continue;

            int cnt = player/m;

            if(server[i]>=cnt) continue;

            int v = cnt - server[i];
            for(int j=i; j<i+k; j++){
                if(j>=24) break;
                server[j]+=v;
            }

            answer += v;
        }

        return answer;
    }
}