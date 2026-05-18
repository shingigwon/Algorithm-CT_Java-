import java.io.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dr = {0,1,1,-1};
		int[] dc = {1,0,1,1};
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[][] board = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				
				for(int j=0; j<N; j++) {
					board[i][j] = input.charAt(j)=='o';
				}
			}
			
			boolean res = false;
			
			outer:
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!board[r][c]) continue;
					
					for(int d=0; d<4; d++) {
						int cnt=1;
						 
						int nr = r;
						int nc = c;
						
						while(true) {
							nr += dr[d];
							nc += dc[d];
							
							if(nr>=N || nr<0 || nc>=N || nc<0) break;
							if(!board[nr][nc]) break;
							
							cnt++;
							
							if(cnt>=5) {
								res = true;
								break outer;
							}
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(res?"YES":"NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
