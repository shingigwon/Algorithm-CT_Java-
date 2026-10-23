class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        
        while(left<right){
            int mid = (left+right)/2;
            
            long total = 0;
            int prev = 0;
            
            for(int i=0; i<diffs.length; i++){
                long level = diffs[i]-mid;
                int cur = times[i];
                
                if(level<=0)
                    total += cur;
                
                else
                    total += level * (prev+cur) + cur;
                
                if(limit<total) break;
                
                prev = cur;
            }
            
            if(total<=limit) right = mid;
            
            else left = mid+1;
        }
        
        return left;
    }
}