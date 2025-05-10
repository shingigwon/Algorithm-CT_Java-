import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		List<Integer>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] vis = new boolean[N+1];
		q.add(new int[] {A,0});
		vis[A] = true; 
		int res = -1;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int c = poll[0];
			int depth = poll[1];
			
			if(c==B) {
				res = depth;
				break;
			}
			
			for(int next:graph[c]) {
				if(!vis[next]) {
					q.add(new int[] {next, depth+1});
					vis[next] = true;
				}
			}
		}
		
		System.out.println(res);
		br.close();
	}
}
