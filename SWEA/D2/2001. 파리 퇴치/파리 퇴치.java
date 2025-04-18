import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
	        int[][] arr = new int[N + 1][N + 1];
	        for (int i = 1; i <= N; i++) {
	            for (int j = 1; j <= N; j++) {
	                arr[i][j] = map[i - 1][j - 1]
	                		+ arr[i - 1][j]
	                        + arr[i][j - 1]
	                        - arr[i - 1][j - 1];
	            }
	        }

	        int max = Integer.MIN_VALUE;
	        for (int i = M; i <= N; i++) {
	            for (int j = M; j <= N; j++) {
	                int sum = arr[i][j]
	                        - arr[i - M][j]
	                        - arr[i][j - M]
	                        + arr[i - M][j - M];
	                max = Math.max(max, sum);
	            }
	        }
			
	        System.out.printf("#%d %d\n", t,max);
		}
		br.close();
	}
	
}


