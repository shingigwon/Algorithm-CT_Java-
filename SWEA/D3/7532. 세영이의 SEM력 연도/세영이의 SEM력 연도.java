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
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int res = 1;
			
						
			while(true) {
				if((res-S)%365 == 0 && (res-E)%24==0 && (res-M)%29==0) {
					break;
				}
				res++;
			}
			
			sb.append("#").append(tc).append(" ")
			.append(res)
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
