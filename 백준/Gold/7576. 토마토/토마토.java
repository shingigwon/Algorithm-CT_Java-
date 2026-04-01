import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    q.add(new int[] {i,j});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;

                if(map[nx][ny]!=0)
                    continue;

                map[nx][ny] = map[x][y]+1;
                q.add(new int[] {nx,ny});
            }
        }

        int res = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    res = -1;
                    break;
                }
                res = Math.max(res, map[i][j]);
            }
            if(res == -1)
                break;
        }

        System.out.println(res == -1 ? -1 : res-1);
        br.close();
    }
}
