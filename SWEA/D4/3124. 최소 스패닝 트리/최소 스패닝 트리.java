import java.io.*;
import java.util.*;
public class Solution {
	static int V,E;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			List<int[]>[] graph = new ArrayList[V+1];
			
			for(int i=1; i<=V; i++) 
				graph[i] = new ArrayList<int[]>();
			
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				graph[A].add(new int[] {B,C});
				graph[B].add(new int[] {A,C});
			}
			
			long ret = bfs(1,graph);
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	static long bfs(int start, List<int[]>[] graph) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(o1,o2)-> Integer.compare(o1[1], o2[1]));
		
		boolean[] vis = new boolean[V+1];
		pq.add(new int[] {1,0});
		
		long ret = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int w = cur[1];
			
			if(vis[v])
				continue;
			
			vis[v] = true;
			ret+=w;
			cnt++;
			
			if(cnt==V) 
				return ret;
			
			for(int[] next : graph[v]) {
				if(!vis[next[0]])
					pq.add(new int[] {next[0], next[1]});
			}
			
		}
		
		
		return 0;
	}
}
