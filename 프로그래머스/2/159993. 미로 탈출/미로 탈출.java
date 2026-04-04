import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int solution(String[] maps) {
        boolean[][] Lvis = new boolean[maps.length][maps[0].length()];
        boolean[][] Evis = new boolean[maps.length][maps[0].length()];

        int[][] map = new int[maps.length][maps[0].length()];

        int[] start = new int[0];
        int[] lever = new int[0];
        int[] exit = new int[0];

        for(int i=0; i<maps.length; i++){
            Arrays.fill(map[i], 1);
            for(int j=0; j<maps[0].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch == 'X')
                    map[i][j] = 0;

                else if(ch == 'S')
                    start = new int[]{i,j};
                else if (ch == 'L')
                    lever = new int[]{i,j};
                else if(ch == 'E')
                    exit = new int[]{i,j};
            }
        }
        int dist1 = bfs(map, Lvis, start, lever);
        int dist2 = bfs(map, Evis, lever, exit);

        if(dist1 == -1 || dist2 == -1)
            return -1;

        return dist1+dist2;
    }
    public int bfs(int[][] map, boolean[][] vis, int[] start, int[] end){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start[0],start[1],0});
        vis[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(cx==end[0] && cy==end[1])
                return dist;

            for(int d=0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length)
                    continue;

                if(map[nx][ny]==0 || vis[nx][ny])
                    continue;

                q.add(new int[] {nx,ny,dist+1});
                vis[nx][ny] = true;
            }

        }
        return -1;
    }
}