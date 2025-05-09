import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] vis = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String[] input = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}
			int[] dx = {0,0,-1,1};
			int[] dy = {1,-1,0,0};
			
			int mid = N/2;
			int sum = 0;
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {mid,mid,0});
			vis[mid][mid] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				int dist = cur[2];
				
				sum+=map[y][x];
				
				if(dist==mid) continue;
				
				for(int i=0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny<0 || ny>=N || nx<0|| nx>=N ||vis[ny][nx])
						continue;
					
					vis[ny][nx] = true;
					q.add(new int[] {ny,nx,dist+1});
				}
			}
			
			
			System.out.printf("#%d %d\n", t, sum);
		}
		br.close();
	}
}
