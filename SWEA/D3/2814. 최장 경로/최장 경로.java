import java.io.*;
import java.util.*;

public class Solution {
	static int N,ret;
	static List<Integer>[] list;
	static boolean[] vis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ret = 1;
			
			if(M!=0) {
				list = new ArrayList[N+1];
				for(int i=1; i<=N; i++) 
					list[i] = new ArrayList<Integer>();
				
				
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					list[x].add(y);
					list[y].add(x);
				}
				for(int i=1; i<=N; i++) {
					vis = new boolean[N+1];
					dfs(i,1);
				}
			}
			
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	
	static void dfs(int node, int depth) {
		vis[node] = true;
		ret = Math.max(ret, depth);
		
		for(int next : list[node]) {
			if(!vis[next])
				dfs(next, depth+1);
		}
		vis[node] = false;
	}
	
}


