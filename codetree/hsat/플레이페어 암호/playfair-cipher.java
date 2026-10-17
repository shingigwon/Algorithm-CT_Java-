import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String key = br.readLine();

        Set<Character> set = new LinkedHashSet<>();

        for(char ch : key.toCharArray()){
            set.add(ch);
        }

        for(char ch = 'A'; ch<='Z'; ch++){
            if(ch == 'J') continue;
            set.add(ch);
        }

        char[][] grid = new char[5][5];

        int r = 0;
        int c = 0;
        for(char ch : set){
            grid[r][c] = ch;
            c++;

            if(c==5){
                c=0;
                r++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(msg.charAt(0));

        for(int i=1; i<msg.length(); i++){
            char prev = sb.charAt(sb.length()-1);
            char cur = msg.charAt(i);

            //홀수이면 치환
            if(sb.length()%2!=0){
                if(prev == cur){
                    if(cur == 'X') sb.append("Q");
                    else sb.append("X");
                }
            }
            sb.append(cur);
        }

        if(sb.length()%2!=0){
            sb.append("X");
        }

        StringBuilder res = new StringBuilder();

        for(int idx=2; idx<=sb.length(); idx+=2){
            char prev = sb.charAt(idx-2);
            char next = sb.charAt(idx-1);

            int r1 = -1;
            int c1 = -1;
            int r2 = -1;
            int c2 = -1;

            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(grid[i][j]==prev){
                        r1 = i;
                        c1 = j;
                    }
                    if(grid[i][j]==next){
                        r2 = i;
                        c2 = j;
                    }
                }
            }
            if(r1==r2)
                res.append(grid[r1][(c1+1)%5]).append(grid[r2][(c2+1)%5]);
            else if(c1==c2){
                res.append(grid[(r1+1)%5][c1]).append(grid[(r2+1)%5][c2]);
            }
            else{
                res.append(grid[r1][c2]).append(grid[r2][c1]);
            }
        }
        System.out.println(res);
    }
}
