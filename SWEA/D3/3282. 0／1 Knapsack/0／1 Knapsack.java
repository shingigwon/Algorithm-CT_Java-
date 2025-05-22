import java.io.*;
import java.util.*;

public class Solution {
	static int N,K;
	static int[] V,C;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			V = new int[N];
			C = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] =  Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[N+1][K+1];
			for(int[] row : dp) 
				Arrays.fill(row, -1);
			
			int ret = dfs(0,0);
			
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
	
	static int dfs(int depth, int vSum) {
		if(vSum>K)
			return Integer.MIN_VALUE;
		
		if(depth == N) 
			return 0;
		
		if(dp[depth][vSum]!=-1)
			return dp[depth][vSum];
		
		return dp[depth][vSum] = Math.max(
				dfs(depth+1, vSum), 
				dfs(depth+1, vSum+V[depth])+C[depth]);
	}
}



