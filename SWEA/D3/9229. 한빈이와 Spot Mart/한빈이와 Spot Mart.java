import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, ret;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ret = -1;
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			dfs(0,0,0);
			System.out.printf("#%d %d\n",t, ret);
			
		}
		
		br.close();
	}
	static void dfs(int cnt, int start, int sum) {
		if(sum>M)
			return;
		
		if(cnt == 2) {
			if(sum<=M) {
				ret=Math.max(ret, sum);
				return;
			}
		}
		
		for(int i=start; i<N; i++) {
			dfs(cnt+1, i+1, sum+arr[i]);
		}
			
	}
}