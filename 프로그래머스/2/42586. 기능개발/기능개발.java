import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            int p = progresses[i];
            int s = speeds[i];
            
            int t = 100-p;
            int d = (t/s)+(t%s==0?0:1);
            
            q.add(d);
        }
        
        while(!q.isEmpty()){
            int day = q.poll();
            
            int cnt = 1;
            
            while(true){
                if(q.isEmpty()) break;
                
                if(day>=q.peek()){
                    q.poll();
                    cnt++;
                }
                else break;
            }
            
            answer.add(cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}