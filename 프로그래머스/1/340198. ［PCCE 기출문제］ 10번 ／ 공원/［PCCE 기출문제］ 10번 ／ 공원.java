import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int R = park.length;
        int C = park[0].length;

        int[][] dp = new int[R][C];

        int max = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(park[i][j].equals("-1")){
                    if(i==0 || j==0)
                        dp[i][j] = 1;

                    else
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        Arrays.sort(mats);
        for(int i=mats.length-1; i>=0; i--){
            if(mats[i]<=max)
                return mats[i];
        }

        return -1;
    }
}