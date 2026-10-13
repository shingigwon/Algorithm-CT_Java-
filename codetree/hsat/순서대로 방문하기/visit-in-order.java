import java.util.*;
import java.io.*;

public class Main {
    static int n,m,res;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] grid, targets;
    static boolean[][] vis;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        targets = new int[m][2];

        vis = new boolean[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            targets[i][0] = Integer.parseInt(st.nextToken());
            targets[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(targets[0][0]-1, targets[0][1]-1,1);
        System.out.println(res);
    }

    static void dfs(int y, int x, int idx){
        vis[y][x] = true;
        
        if(idx == m){
            res++;
            vis[y][x] = false;
            return;
        }

        for(int d=0; d<4; d++){
            int ny = y+dy[d];
            int nx = x+dx[d];

            if(ny<0 || ny>=n || nx<0 || nx>=n) continue;

            if(grid[ny][nx]==1 || vis[ny][nx]) continue;

            if(ny == targets[idx][0]-1 && nx == targets[idx][1]-1)
                dfs(ny, nx, idx+1);

            else
                dfs(ny, nx, idx);
        }

        vis[y][x] = false;
    }
}