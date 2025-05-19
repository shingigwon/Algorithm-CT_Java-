import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] nums = new int[N];
			
			for(int i=0; i<N; i++) 
				nums[i] = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[N];
			Arrays.fill(dp, 1);
			
			for(int i=1; i<N; i++) {
				for(int j=0; j<i; j++) {
					if(nums[j]<nums[i])
						dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			
			int ret = Arrays.stream(dp).max().getAsInt();
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
}