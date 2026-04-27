class Solution {
    boolean[] used;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        used = new boolean[dungeons.length];
        perm(k, 0, dungeons);
        return max;
    }

    void perm(int fatigue, int cnt, int[][] dungeons){
        max = Math.max(max, cnt);

        for(int i=0; i<dungeons.length; i++){
            if(used[i]) continue;

            if(fatigue < dungeons[i][0]) continue;

            used[i] = true;

            perm(fatigue-dungeons[i][1], cnt+1, dungeons);

            used[i] = false;
        }

    }
}