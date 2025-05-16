import java.io.*;
import java.util.*;

public class Solution {
	static int N, L;
	static int[] keys, values;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			keys = new int[N];
			values = new int[N];
			max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				keys[i] = T;
				values[i] = K;
			}
			
			dfs(0,0,0);
			System.out.printf("#%d %d\n", t, max);
		}
		br.close();
	}
	
	static void dfs(int idx, int kSum, int vSum) {
		if(vSum>L) return;
		if(idx==N) {
			max = Math.max(max, kSum);
			return;
		}
		
		dfs(idx+1, kSum, vSum);
		
		dfs(idx+1, kSum+keys[idx], vSum+values[idx]);
	}
}