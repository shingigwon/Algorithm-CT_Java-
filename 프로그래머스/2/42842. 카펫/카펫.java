class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        
        for(int i=2; i*i<=sum; i++){
            if(sum%i==0){
                int a = sum/i;
                if((i-2) * (a-2) == yellow){
                    if(i>a){
                        answer[0] = i;
                        answer[1] = a;    
                    }
                    else{
                        answer[0] = a;
                        answer[1] = i;
                    }
                }
            }
        }
        return answer;
    }
}