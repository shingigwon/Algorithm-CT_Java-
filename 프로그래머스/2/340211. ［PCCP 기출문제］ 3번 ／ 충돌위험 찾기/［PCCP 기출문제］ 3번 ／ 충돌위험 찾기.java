import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++){
            int sp = routes[i][0]-1;
            
            int sr = points[sp][0];
            int sc = points[sp][1];
            int t = 0;
            
            String key = sr+", "+sc+", "+t;
            answer += collision(map, key);
            
            for(int j=0; j<routes[i].length; j++){
                int ep = routes[i][j]-1;
                int er = points[ep][0];
                int ec = points[ep][1];
                       
                while(sr!=er){
                    if(sr<er) sr++;
                    else sr--;

                    t++;
                    key = sr+", "+sc+", "+t;

                    answer+=collision(map, key);
                }

                while(sc!=ec){
                    if(sc<ec) sc++;
                    else sc--;

                    t++;
                    key = sr+", "+sc+", "+t;
                    answer+=collision(map, key);
                }
            }
        }
        return answer;
    }

    private int collision(Map<String, Integer> map, String key){
        if(map.containsKey(key)){
            if(map.get(key) == 1){
                map.put(key, 2);
                return 1;
            }
        }
        else map.put(key, 1);
        return 0;
    }
}