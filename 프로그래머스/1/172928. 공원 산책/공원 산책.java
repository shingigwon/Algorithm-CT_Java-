import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int H = park.length;
        int W = park[0].length();
        
        int sr = -1;
        int sc = -1;
        
        for(int r=0; r<H; r++){
            String input = park[r];
            
            for(int c=0; c<W; c++){
                char ch = input.charAt(c);
                if(ch == 'S'){
                    sr = r;
                    sc = c;
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        
        int cr = sr;
        int cc = sc;
        
        for(int i=0; i<routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            char cmd = st.nextToken().charAt(0);
            int move = Integer.parseInt(st.nextToken());
            
            int dir = -1;
            
            if(cmd == 'N'){
                dir = 0;
            }
            else if(cmd == 'E'){
                dir = 1;
            }
            else if(cmd == 'S'){
                dir = 2;
            }
            else if(cmd == 'W'){
                dir = 3;
            }
            
            int nr = cr;
            int nc = cc;
            
            boolean chk = true;
            
            for(int d=0; d<move; d++){
                nr += dr[dir];
                nc += dc[dir];
                
                if(nr<0 || nr>=H || nc<0 || nc>=W || park[nr].charAt(nc) == 'X'){
                    chk = false;
                    break;
                }
            }
            
            if(!chk) continue;
            
            cr = nr;
            cc = nc;
        }
        
        answer[0] = cr;
        answer[1] = cc;
            
        return answer;
    }
}