import java.util.*;

public class BacktrackingExamples {

    // ===================== N-Queen =====================
    static int N;
    static int[] board; // board[row] = col (퀸의 열 위치)
    static int queenCount = 0;

    static void nQueen(int row) {
        if (row == N) {
            queenCount++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!isValidQueen(row, col)) continue; // 가지치기

            board[row] = col;
            nQueen(row + 1);
            // 복원 불필요 - board[row]는 다음 루프에서 덮어씌워짐
        }
    }

    static boolean isValidQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) return false;                           // 같은 열
            if (Math.abs(board[i] - col) == Math.abs(i - row)) return false; // 대각선
        }
        return true;
    }

    // ===================== 스도쿠 =====================
    static int[][] sudoku = new int[9][9];

    static boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] != 0) continue; // 이미 채워진 칸 skip

                for (int num = 1; num <= 9; num++) {
                    if (!isValidSudoku(row, col, num)) continue; // 가지치기

                    sudoku[row][col] = num;

                    if (solveSudoku()) return true; // 끝까지 성공하면 true

                    sudoku[row][col] = 0; // 복원
                }
                return false; // 1~9 전부 실패 → 이전 단계로
            }
        }
        return true; // 모든 칸 채움
    }

    static boolean isValidSudoku(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) return false; // 같은 행
            if (sudoku[i][col] == num) return false; // 같은 열
        }
        // 3x3 박스 체크
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (sudoku[i][j] == num) return false;
            }
        }
        return true;
    }
}
