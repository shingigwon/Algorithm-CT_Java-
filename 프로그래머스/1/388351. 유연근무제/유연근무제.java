class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i=0; i<schedules.length; i++){
            int limit = toMinutes(schedules[i])+10;
            boolean success = true;

            for(int j=0; j<7; j++){
                int day = (startday+j-1)%7+1;
                if(day>=6) continue;

                if(toMinutes(timelogs[i][j])>limit){
                    success = false;
                    break;
                }
            }

            if(success) answer++;
        }
        return answer;
    }

    private int toMinutes(int hhmm){
        return hhmm/100 * 60 + hhmm%100;
    }
}