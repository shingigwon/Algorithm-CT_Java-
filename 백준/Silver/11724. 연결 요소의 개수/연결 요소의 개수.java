import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
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
		int count=0;
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
		br.close();
	}

	static void DFS(int v) {
		if(visited[v])
			return;
		
		visited[v]=true;
		for(int i:arr[v]) {
			if(!visited[i])
				DFS(i);
		}
		
	}
}