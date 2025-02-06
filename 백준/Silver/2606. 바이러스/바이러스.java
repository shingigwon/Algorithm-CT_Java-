import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		arr = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[u].add(v);
			arr[v].add(u);
		}
		int count = DFS(1)-1;
		System.out.println(count);
		
		br.close();
	}

	static int DFS(int v) {
        int count = 1;

		visited[v] = true;
		for (int j : arr[v]) {
			if (!visited[j])
				count+=DFS(j);
		}
		return count;
	}
}