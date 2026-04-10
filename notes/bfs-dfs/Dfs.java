import java.util.*;

public class DFS {

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // 기본 DFS - 재귀
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    // 백트래킹 DFS - 조합/순열 (ex. N과 M)
    static int[] arr;
    static boolean[] used;
    static int R;

    static void backtrack(int depth, List<Integer> current) {
        if (depth == R) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(arr[i]);

            backtrack(depth + 1, current);

            // 상태 복원 필수 - 빠뜨리면 다른 경로 탐색 불가
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    // Stack DFS - 재귀 깊이 제한 우회 (노드 10만 이상일 때)
    static void dfsStack(int startX, int startY) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                stack.push(new int[]{nx, ny});
            }
        }
    }
}
