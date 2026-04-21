class Solution {
    public int solution(int k, int m, int[] score) {
        int[] cnt = new int[k+1];
        int sum = 0;

        for(int s : score){
            cnt[s]++;
        }

        int mod = 0;
        for(int i=k; i>0; i--){
            if(cnt[i]==0)
                continue;

            mod += cnt[i]%m;

            if(mod>=m){
                mod%=m;
                sum+=i*m;
            }

            sum+=(cnt[i]/m)*i*m;
        }

        return sum;
    }
}