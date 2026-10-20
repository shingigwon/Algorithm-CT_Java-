import java.util.*;

class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    int len;
    List<List<int[]>> spaces;
    List<List<int[]>> puzzles;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        len = game_board.length;
        boolean[][] boardVis = new boolean[len][len];
        boolean[][] puzzleVis = new boolean[len][len];

        spaces = new ArrayList<>();
        puzzles = new ArrayList<>();

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j]==0 && !boardVis[i][j]){
                    bfs(i,j, game_board, boardVis, 1);
                }
                if(table[i][j]==1 && !puzzleVis[i][j]){
                    bfs(i,j, table, puzzleVis, 0);
                }
            }
        }
        boolean[] used = new boolean[puzzles.size()];

        for(List<int[]> space : spaces){
            outer:
            for(int i=0; i<puzzles.size(); i++){
                if(used[i]) continue;

                List<int[]> puzzle = puzzles.get(i);

                if(space.size()!= puzzle.size()) continue;

                for(int r=0; r<4; r++){
                    boolean chk = true;
                    for(int j=0; j<space.size(); j++){
                        int[] o1 = space.get(j);
                        int[] o2 = puzzle.get(j);

                        if(o1[0]!=o2[0] || o1[1]!=o2[1]) {
                            chk = false;
                            break;
                        }
                    }

                    if(chk) {
                        used[i] = true;
                        answer+=puzzle.size();
                        break outer;
                    }
                    puzzle = rotation(puzzle);
                }
            }
        }
        return answer;
    }

    void bfs(int r, int c, int[][] map, boolean[][] vis, int v){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        vis[r][c] = true;

        List<int[]> shape = new ArrayList<>();
        shape.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];

                if(nr<0 || nr>=len || nc<0 || nc>=len) continue;
                if(map[nr][nc] == v ||vis[nr][nc]) continue;

                q.add(new int[] {nr,nc});
                vis[nr][nc] = true;

                shape.add(new int[] {nr-r, nc-c});
            }
        }

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for (int[] pos : shape) {
            minR = Math.min(minR, pos[0]);
            minC = Math.min(minC, pos[1]);
        }

        for (int[] pos : shape) {
            pos[0] -= minR;
            pos[1] -= minC;
        }

        shape.sort(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        if(v==0) puzzles.add(shape);
        else spaces.add(shape);
    }

    //r,c -> c,-r
    List<int[]> rotation(List<int[]> shape){
        List<int[]> rotList = new ArrayList<>();
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for (int[] cur : shape) {
            int r = cur[0];
            int c = cur[1];

            rotList.add(new int[]{c, -r});

            minR = Math.min(minR, c);
            minC = Math.min(minC, -r);

        }

        for(int[] pos : rotList){
            pos[0] -= minR;
            pos[1] -= minC;
        }

        rotList.sort(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        return rotList;
    }
}
