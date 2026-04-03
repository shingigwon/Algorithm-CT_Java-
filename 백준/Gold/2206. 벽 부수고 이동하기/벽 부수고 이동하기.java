import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int [][] map = new int[N][M];
        boolean [][][] visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 0, 1});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int status = cur[2];
            int dist = cur[3];

            if(cx == N-1 && cy == M-1){
                System.out.println(dist);
                return;
            }

            for(int d=0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;

                if(visited[nx][ny][status])
                    continue;

                if(map[nx][ny] == 0){
                    if(!visited[nx][ny][status]){
                        visited[nx][ny][status] = true;
                        q.add(new int[]{nx, ny, status, dist+1});
                    }
                }

                else if(map[nx][ny]==1 && status == 0){
                    if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.add(new int[] {nx, ny, 1, dist +1});
                    }
                }
            }
        }
        System.out.println(-1);
        br.close();
    }
}
