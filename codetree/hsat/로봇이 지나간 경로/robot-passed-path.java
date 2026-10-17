import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] grid = new char[H][W];

        for(int h=0; h<H; h++){
            String input = br.readLine();
            for(int w=0; w<W; w++){
                grid[h][w] = input.charAt(w);
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        char[] direction = {'^','>','v','<'};

        //시작점 - 행r 열c 큰순
        int sr = -1;
        int sc = -1;
        int sd = -1;

        for(int r=0; r<H; r++){
            for(int c=0; c<W; c++){
                if(grid[r][c]=='.') continue;

                int cnt = 0;
                int dir = 0;

                for(int d=0; d<4; d++){
                    int nr = r+dr[d];
                    int nc = c+dc[d];

                    if(nr<0 || nr>=H || nc<0 || nc>=W) continue;

                    if(grid[nr][nc]=='#'){
                        cnt++;
                        dir = d;
                    }
                }
                if(cnt == 1){
                    sr = r;
                    sc = c;
                    sd = dir;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sr+1).append(" ").append(sc+1).append("\n")
            .append(direction[sd]).append("\n");


        boolean[][] vis = new boolean[H][W];
        String[] cmds = {"A", "LA", "RA"};

        int r = sr;
        int c = sc;
        int d = sd;
      
        vis[r][c] = true;

        while(true){
            boolean chk = false;
            int[] nextDirs = {d, (d+3)%4, (d+1)%4};

            for(int i=0; i<3; i++){
                int nd = nextDirs[i];

                int nr1 = r+dr[nd];
                int nc1 = c+dc[nd];

                int nr2 = r+dr[nd]*2;
                int nc2 = c+dc[nd]*2;

                if(nr2<0 || nr2>=H || nc2<0 || nc2>=W) continue;

                if(grid[nr1][nc1]!='#' || grid[nr2][nc2]!='#') continue;
                if(vis[nr1][nc1] || vis[nr2][nc2]) continue;

                vis[nr1][nc1] = true;
                vis[nr2][nc2] = true;
                sb.append(cmds[i]);

                r = nr2;
                c = nc2;
                d = nd;

                chk = true;
                break;
            }

            if(!chk) break;
        }



        System.out.println(sb);
    }
}