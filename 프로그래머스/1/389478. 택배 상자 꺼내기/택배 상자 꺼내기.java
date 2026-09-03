import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        int h = n % w == 0 ? n / w : n / w + 1;
        boolean[][] box = new boolean[h + 1][w + 1];

        for (int i = h; i >= 1; i--) {
            Arrays.fill(box[i], true);
        }

        int end = n % w;
        if (end != 0) {
            if (h % 2 == 0) {
                for (int i = 1; i <= w - end; i++) {
                    box[h][i] = false;
                }
            } else {
                for (int i = end + 1; i <= w; i++) {
                    box[h][i] = false;
                }
            }
        }

        int row = (num / w) + 1;
        int col = num % w;

        if (col == 0) {
            row--;
            col = w;
        }

        if (row % 2 == 0) {
            col = w - col + 1;
        }

        int answer = 0;
        for (int i = h; i >= 1; i--) {
            if (box[i][col]) answer++;
            if (i == row) break;
        }
        return answer;
    }
}
