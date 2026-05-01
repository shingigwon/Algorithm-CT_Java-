import java.util.*;

class Solution {

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        char[][] map;

        for(int t=0; t<places.length; t++){
            map = new char[places[t].length][places[t][0].length()];

            for(int i=0; i<places[t].length; i++){
                map[i] = places[t][i].toCharArray();
            }

            boolean chk = true;

            outer:
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 'P' && !bfs(i, j, map)) {
                        chk = false;
                        break outer;
                    }
                }
            }

            answer[t] = chk?1:0;
        }
        return answer;
    }

    boolean bfs(int x, int y, char[][] map){
        boolean[][] vis = new boolean[map.length][map[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y,0});
        vis[x][y] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(dist==2) continue;

            for(int d = 0; d<4; d++){
                int nx = cx+dx[d];
                int ny = cy+dy[d];

                if(nx<0 || nx>=map.length || ny<0 || ny>=map[0].length) continue;
                if(vis[nx][ny] || map[nx][ny]=='X') continue;

                if(map[nx][ny]=='P') return false;

                q.add(new int[] {nx,ny,dist+1});
                vis[nx][ny] = true;
            }
        }

        return true;
    }
}
