class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] vis = new boolean[n];
        int answer = 0;
        
        for(int i : section){
            vis[i-1] = true;
        }
        
        for(int i=0; i<n; i++){
            if(!vis[i])
                continue;
            
            for(int j=i; j<Math.min(i+m, n); j++){
                vis[j] = false;
            }   
            
            answer++;
        }
        
        return answer;
    }
}