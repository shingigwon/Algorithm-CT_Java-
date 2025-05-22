import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[][] vis = new boolean[N*2+1][N*2+1];

			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {0,0});
			vis[N][N] = true;
			int ret = 1;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				
				
				for(int i=0; i<4; i++) {
					int y= cy+dy[i];
					int x = cx+dx[i];
					
					int ny = y+N;
					int nx = x+N;
					
					if(x*x + y*y<=N*N && !vis[ny][nx]) {
						q.add(new int[] {y,x});
						vis[ny][nx] = true;
						ret++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
}

