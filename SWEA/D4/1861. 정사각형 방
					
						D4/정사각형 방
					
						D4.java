import java.io.*;
import java.util.*;

class Solution{
	static int N;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		StringTokenizer st;
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			int room = Integer.MAX_VALUE;
			int cnt = Integer.MIN_VALUE;

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int res = dfs(i,j);
					
					if(res>cnt) {
						cnt = res;
						room = board[i][j];
					}
					else if(res == cnt) {
						room = Math.min(room, board[i][j]);
					}
						
				}
			}
			
			sb.append("#").append(tc).append(" ")
			.append(room).append(" ").append(cnt)
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int dfs(int x, int y) {
		int count = 1;
			
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx>=N || nx<0 || ny>=N || ny<0) continue;
			
			if(board[nx][ny] == board[x][y]+1) {
				count = Math.max(count, dfs(nx,ny)+1);
			}
		}
		
		return count;
	}
}
