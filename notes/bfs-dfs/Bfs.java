import java.util.*;

public class BFS {

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    // 상하좌우 방향 벡터
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();

        // 시작 노드 삽입 + 방문 처리 (꺼낼 때 X, 넣을 때 O)
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크 → 방문 여부 체크 → 조건 체크 순서 지킬 것
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (graph[nx][ny] == 0) continue; // 벽이면 skip

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    // 멀티소스 BFS - 시작점 여러 개일 때 (ex. 토마토)
    static int[][] multiSourceBFS(List<int[]> sources) {
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1); // -1 = 미방문

        Queue<int[]> queue = new ArrayDeque<>();

        // 시작점 전부 큐에 넣고 시작
        for (int[] src : sources) {
            queue.offer(src);
            dist[src[0]][src[1]] = 0;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (dist[nx][ny] != -1) continue; // 이미 방문

                dist[nx][ny] = dist[x][y] + 1; // 거리 누적
                queue.offer(new int[]{nx, ny});
            }
        }
        return dist;
    }
}
