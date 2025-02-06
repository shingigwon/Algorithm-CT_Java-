import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					list.add(DFS(i, j));
					count++;
				}
			}
		}
        Collections.sort(list);
        
		System.out.println(count);
		for (int n : list)
			System.out.println(n);
		br.close();
	}

	static int DFS(int x, int y) {
		int pop = 0;
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] { x, y });
		visited[x][y] = true;

		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			pop++;
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					stack.push(new int[] { nx, ny });
				}
			}

		}
		return pop;
	}

}