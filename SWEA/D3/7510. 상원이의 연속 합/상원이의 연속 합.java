import java.io.*;
class Solution{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		for(int tc = 1; tc<=T; tc++) {
			int res = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			
			dp[0] = 0;
			for(int i=1; i<=N; i++) {
				dp[i] = dp[i-1]+i;
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=i; j<=N; j++) {
					int sum = dp[j] - dp[i-1];
					
					if(sum==N) {
						res++;
						break;
					}
					
					if(sum>N)
						break;
				}
			}
			
			sb.append("#").append(tc).append(" ")
			.append(res)
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
