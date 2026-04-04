import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(cx==maps.length-1 && cy==maps[0].length-1)
                return dist;

            for(int d=0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<0||nx>=maps.length||ny<0||ny>=maps[0].length)
                    continue;

                if(maps[nx][ny]==0||visited[nx][ny])
                    continue;

                q.add(new int[] {nx,ny,dist+1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}