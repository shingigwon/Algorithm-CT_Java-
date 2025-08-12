import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] vis;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vis = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    vis[M - 1 - y][x] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if(!vis[y][x]){
                    list.add(BFS(y, x));
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list)
            System.out.print(i + " ");
    }

    static int BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        vis[y][x] = true;
        int res = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                if (vis[ny][nx]) continue;
                ;

                q.add(new int[]{ny, nx});
                vis[ny][nx] = true;
                res++;
            }
        }
        return res;
    }
}