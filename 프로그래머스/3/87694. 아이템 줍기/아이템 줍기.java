import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] map = new boolean[101][101];
        boolean[][] vis = new boolean[101][101];

        for (int[] i : rectangle) {
            int lx = i[0];
            int ly = i[1];
            int rx = i[2];
            int ry = i[3];

            for (int x=lx*2; x<=rx*2; x++) {
                for (int y=ly*2; y<=ry*2; y++) {
                    map[x][y] = true;
                }
            }
        }

        for (int[] i : rectangle) {
            int lx = i[0];
            int ly = i[1];
            int rx = i[2];
            int ry = i[3];

            for (int x=lx*2+1; x<rx*2; x++) {
                for (int y=ly*2+1; y<ry*2; y++) {
                    map[x][y] = false;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {characterX*2, characterY*2,0});
        vis[characterX*2][characterY*2] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(cx == itemX*2 && cy == itemY*2){
                return dist/2;
            }

            for(int d=0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<1 || nx>100 || ny<1 || ny>100) continue;

                if(!map[nx][ny] || vis[nx][ny]) continue;

                q.add(new int[] {nx, ny, dist+1});
                vis[nx][ny] = true;
            }
        }

        return -1;
    }
}