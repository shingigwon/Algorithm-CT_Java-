class Solution {
    int k = 3;

    public int solution(int[] nums) {
        return dfs(0, 0, 0, nums);
    }

    int dfs(int depth, int idx, int sum, int[] nums){
        if(depth == k){
            boolean isPrime = true;
            for(int i=2; i*i<=sum; i++){
                if(sum%i==0){
                    isPrime = false;
                    break;
                }
            }
            return isPrime?1:0;
        }

        if(idx==nums.length)
            return 0;

        return dfs(depth, idx+1, sum, nums)+
        dfs(depth+1, idx+1,sum+nums[idx], nums);
    }
}