import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int A = W*P;		
			int B = W<=R?Q:Q+(W-R)*S;
				
			sb.append("#").append(tc).append(" ").append(Math.min(A, B)).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
