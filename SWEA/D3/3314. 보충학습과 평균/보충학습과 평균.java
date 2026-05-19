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
			
			int sum = 0;
			for(int i=0; i<5; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				num = num<40?40:num;
				sum+=num;
			}
			
			sb.append("#").append(tc).append(" ")
			.append(sum/5)
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
