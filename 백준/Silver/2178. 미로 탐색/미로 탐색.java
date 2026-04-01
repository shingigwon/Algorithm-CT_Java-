import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int N;
    static int M;

    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);
        br.close();
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(cx == N-1 && cy == M-1)
                return;

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                if(map[nx][ny]!=1)
                    continue;

                map[nx][ny] = map[cx][cy]+1;
                q.add(new int[]{nx, ny});

            }
        }
    }
}
