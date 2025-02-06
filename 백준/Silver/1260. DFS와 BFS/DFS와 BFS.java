import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[u].add(e);
			arr[e].add(u);
		}
		
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
        visited = new boolean[N + 1];
		DFS(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		BFS(V);
		System.out.println(sb.toString());
		br.close();
	}

	static void DFS(int v) {
	    Stack<Integer> stack = new Stack<>();
	    stack.push(v);
	    visited[v] = true;
	    sb.append(v).append(" ");

	    while (!stack.isEmpty()) {
	        int current = stack.peek();
	        boolean notVisited = false;

	        for (int next : arr[current]) {
	            if (!visited[next]) {
	                stack.push(next);
	                visited[next] = true;
	                sb.append(next).append(" ");
	                notVisited = true;
	                break;
	            }
	        }

	        if (!notVisited) {
	            stack.pop();
	        }
	    }
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;
		sb.append(v).append(" ");
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			
			for(int next:arr[poll]) {
				if(!visited[next]) {
					visited[next]=true;
					queue.add(next);
					sb.append(next).append(" ");
				}
			}
		}
	}
}
