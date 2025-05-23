import java.io.*;
import java.util.*;
public class Solution {
	static boolean[] vis;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			vis = new boolean[N+1];
			list = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) 
				list[i] = new ArrayList<Integer>();
			
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				list[A].add(B);
				list[B].add(A);
			}
			int ret = 0;
			for(int i=1; i<=N; i++) {
				if(vis[i])
					continue;
				
				bfs(i);
				ret++;
			}
			
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		vis[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : list[cur]) {
				if(!vis[next]) {
					q.add(next);
					vis[next] = true;
				}
			}
		}
	}
}
