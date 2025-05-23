import java.io.*;
import java.util.*;
public class Solution {
	static int N,ret;
	static int[][] nums;
	static char[][] map;
	static boolean[][] vis;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t=1; t<=TC; t++) {
			N = Integer.parseInt(br.readLine());
			ret=0;
			map = new char[N][N];
			nums = new int[N][N];
			vis = new boolean[N][N];

			//
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<N; j++) 
					map[i][j] = input.charAt(j);
			}
            
			//
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int tnt = 0;
					if(map[i][j] == '*') {
						nums[i][j] = -1;
						continue;
					}
					for(int k=0; k<8; k++) {
						int y = i+dr[k];
						int x = j+dc[k];
						
						if(y<0 || y>=N || x<0 || x>=N)
							continue;
						
						if(map[y][x]=='*')
							tnt++;
					}
					nums[i][j] = tnt;
				}
			}
			
			//1
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(nums[i][j]==0 && !vis[i][j]) {
						bfs(i,j);
						ret++;
					}
				}
			}
			
			//2
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(nums[i][j]>0 && !vis[i][j]) {
						ret++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	
	static void bfs(int sy, int sx) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {sy, sx});
		vis[sy][sx] = true;
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for(int i=0; i<8; i++) {
				int ny = cy+dr[i];
				int nx = cx+dc[i];
				
				
				if (ny<0 || ny>=N || nx<0 || nx>=N)
					continue;
	            if (vis[ny][nx] || nums[ny][nx]==-1)
	            	continue;

	            vis[ny][nx] = true;
	            if (nums[ny][nx] == 0) 
	                q.add(new int[]{ny, nx});
				
			}
		}
	}
}
