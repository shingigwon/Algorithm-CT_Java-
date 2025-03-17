import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] vis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		int res = 0;

		for (int h = 0; h <= max; h++) {
			vis = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !vis[i][j]) {
						Func(i, j, h);
						cnt++;
					}
				}
			}
			res = Math.max(res, cnt);
		}

		System.out.println(res);
		br.close();
	}

	static void Func(int y, int x, int h) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { y, x });
		vis[y][x] = true;

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int cy = poll[0];
			int cx = poll[1];

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < N && ny >= 0 && nx >= 0 && nx < N) {
					if (!vis[ny][nx] && map[ny][nx] > h) {
						q.add(new int[] { ny, nx });
						vis[ny][nx] = true;
					}
				}
			}
		}
	}
}
