import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
//						 1	 2	 3	 4	  5	   6	7	 8	  9	   10	11	 12
//						 31  28  31  30   31   30   31   31   30   31   30   31  	
		int[] daySum = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int mouth1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			
			int mouth2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
		
			int res = (daySum[mouth2]+day2) - (daySum[mouth1]+day1) +1;

			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
