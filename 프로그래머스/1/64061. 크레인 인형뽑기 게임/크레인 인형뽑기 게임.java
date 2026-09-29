import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int[] top = new int[board.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i]==0) continue;
                top[i] = j;
                break;
            }
        }
        int answer = 0;

        for(int i=0; i<moves.length; i++){
            int idx = moves[i]-1;

            if(top[idx]>=board.length) continue;

            int value = board[top[idx]][idx];
            Integer peek = stack.peek();

            if (peek != null && peek == value) {
                stack.pop();
                answer += 2;
            }
            else{
                stack.push(value);
            }

            top[idx]++;
        }

        return answer;
    }
}