import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int [] nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				nums[i] = Integer.parseInt(st.nextToken());
			
			
			int len = Arrays.stream(nums).sum();
			boolean[] dp = new boolean[len+1];
			dp[0] = true;
			
			for(int i=0; i<N; i++) {
				int num = nums[i];
				for(int j=len; j>=num; j--) {
					if(dp[j-num])
						dp[j] = true;
				}
			}
			
			int ret = 0;
			for(int i=0; i<=len; i++) {
				if(dp[i])
					ret++;
			}
			
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
}
