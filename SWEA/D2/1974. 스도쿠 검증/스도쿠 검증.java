import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc = 1; tc<=T; tc++) {
			int[][] puzzle = new int[9][9];
			boolean[] vis = new boolean[10];		
			boolean res = true;
			
			StringTokenizer st;
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(vis, false);				
				
				for(int j=0; j<9; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(vis[num]) res = false;
					
					vis[num] = true;
					puzzle[i][j] = num;
				}
			}
			if (res) res = chkCol(puzzle, vis);
			if (res) res = chkBox(puzzle, vis);
			
			sb.append("#").append(tc).append(" ").append(res?1:0).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	static boolean chkCol(int[][] puzzle, boolean[] vis) {
		
			for(int i=0; i<9; i++) {
				Arrays.fill(vis, false);				
				
				for(int j=0; j<9; j++) {
					int num = puzzle[j][i];
					
					if(vis[num]) return false;
					
					vis[num] = true;
						
				}
			}
		return true;
	}
	
	static boolean chkBox(int[][] puzzle, boolean[] vis) {
		for(int i=0; i<9; i+=3) {
			for(int j=0; j<9; j+=3) {
				Arrays.fill(vis, false);
				
				for(int r=i; r<i+3; r++) {
					for(int c=j; c<j+3; c++) {
						int num = puzzle[r][c];
						
						if(vis[num]) return false;
						
						vis[num] = true;
						
					}
				}
			}
		}
		return true;
	}
}