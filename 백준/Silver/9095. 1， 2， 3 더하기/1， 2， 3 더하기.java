import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];	
			dp[0] = 1;
			
			for(int i=1; i<=N; i++) {
				if(i>=1)
					dp[i] += dp[i-1];
				if(i>=2)
					dp[i] += dp[i-2];
				if(i>=3)
					dp[i] += dp[i-3];
			}
			System.out.println(dp[N]);
		}
		
        br.close();
	}

}