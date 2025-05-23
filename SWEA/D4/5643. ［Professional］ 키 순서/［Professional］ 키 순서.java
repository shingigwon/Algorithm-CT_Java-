import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			List<Integer>[] forw = new ArrayList[N+1];
			List<Integer>[] reverse = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				forw[i] = new ArrayList<Integer>();
				reverse[i] = new ArrayList<Integer>();				
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				forw[A].add(B);
				reverse[B].add(A);
			}
			int ret = 0;
			
			boolean[] vis = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				int b = bfs(i, forw, vis);
				int s = bfs(i, reverse, vis);
				
				if(b+s == N-1)
					ret++;
				
			}
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	
	static int bfs(int start, List<Integer>[] list, boolean[] vis) {
		Arrays.fill(vis, false);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		vis[start] = true;
		
		int ret = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				if(!vis[next]) {
					q.add(next);
					vis[next] = true;
					ret++;
				}
			}
		}
		return ret;
	}
}


