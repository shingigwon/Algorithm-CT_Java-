import java.util.Arrays;

class Solution {

    boolean[][] map;
    public int solution(int[] mats, String[][] park) {
        int R = park.length;
        int C = park[0].length;

        map = new boolean[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(park[i][j].equals("-1")){
                    map[i][j] = true;
                }
            }
        }

        Arrays.sort(mats);

        for(int idx = mats.length-1; idx>=0; idx--){
            int mat = mats[idx];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!map[i][j]) continue;

                    if(i+mat > R || j+mat > C) continue;

                    if(isRectangle(i,j,mat)) return mat;
                }
            }
        }

        return -1;
    }

    boolean isRectangle(int r, int c, int size){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(!map[i][j]) return false;
            }
        }
        return true;
    }
}