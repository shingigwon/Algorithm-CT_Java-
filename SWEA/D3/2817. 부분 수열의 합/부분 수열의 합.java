import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, ret;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ret = 0;
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				nums[i] = Integer.parseInt(st.nextToken());
			
			dfs(0,0);
			
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
	static void dfs(int depth, int sum) {
		if(sum==K) {
			ret++;
			return;
		}
		
		if(depth == N) 
			return;
		
		
		dfs(depth+1, sum);
		dfs(depth+1, sum+nums[depth]);
	}
}


