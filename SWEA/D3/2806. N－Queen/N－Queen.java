import java.io.*;

class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] board = new int[N];
            int res = 0;

            res += dfs(0, N, board);

            System.out.printf("#%d %d\n", tc, res);
        }
    }

    static int dfs(int row, int N, int[] board){
        if(row==N)
            return 1;

        int res = 0;

        for(int col=0; col<N; col++){
            if(!isCheck(row, col, board)) continue;

            board[row] = col;
            res+=dfs(row+1, N, board);
        }

        return res;
    }

    static boolean isCheck(int row, int col, int[] board){
        for(int i=0; i<row; i++){
            if(board[i]==col) return false;
            if(Math.abs(board[i]-col) == Math.abs(i-row)) return false;
        }
        return true;
    }
}