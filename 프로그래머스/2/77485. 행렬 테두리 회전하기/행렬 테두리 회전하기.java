class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows+1][columns+1];
        int idx = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = idx++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int temp = map[x1][y1];
            int min = Integer.MAX_VALUE;

            // top
            for(int t=x1; t<x2; t++){
                int v = map[t+1][y1];
                min = Math.min(min, v);
                map[t][y1] = v;
            }

            // left
            for(int l=y1; l<y2; l++){
                int v = map[x2][l+1];
                min = Math.min(min,v);
                map[x2][l] = v;
            }

            // bottom
            for(int b=x2; b>x1; b--){
                int v = map[b-1][y2];
                min = Math.min(min,v);
                map[b][y2] = v;
            }

            // right
            for(int r=y2; r>y1; r--){
                int v = map[x1][r-1];
                min = Math.min(min,v);
                map[x1][r] = v;
            }
            min = Math.min(min,temp);
            map[x1][y1+1] = temp;
            answer[i] = min;
        }

        return answer;
    }
}
