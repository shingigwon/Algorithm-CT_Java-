import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());;
			}
			
			int res = 0;
			
			for(int i=0; i<N; i++) {
				int row = 0;
				int col = 0;
				
				for(int j=0; j<N; j++) {
					if(map[i][j]==1) row++;
					
					else {
						if(row==K) res++;
						row=0;
					}
					
					if(map[j][i]==1) col++;
					
					else {
						if(col==K) res++;
						col=0;
					}
				}
				
				if(row==K) res++;
				
				if(col==K) res++;
				
			}
			
			System.out.printf("#%d %d\n",t, res);
		}
		br.close();
	}	
}
