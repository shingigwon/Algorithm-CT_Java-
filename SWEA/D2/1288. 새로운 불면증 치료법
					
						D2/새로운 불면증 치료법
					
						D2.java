import java.io.*;
import java.util.*;

class Solution{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<>();
			int res = 0;
			
			int idx = 1;
			while(set.size()< 10) {
				int target = N*idx++;
				
				String s = Integer.toString(target);
				
				for(int i=0; i<s.length(); i++) {
					int num = s.charAt(i)-'0';
					set.add(num);
				}
				res = target;
			}
			
			sb.append("#").append(tc).append(" ")
			.append(res)
			.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
