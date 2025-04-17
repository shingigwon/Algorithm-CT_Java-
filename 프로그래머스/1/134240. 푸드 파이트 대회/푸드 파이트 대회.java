class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            int n = food[i]/2;
            
            for(int j=0; j<n; j++)
                sb.append(i);                
        }
        answer.append(sb.toString()).append("0").append(sb.reverse().toString());
        return answer.toString();
    }
}