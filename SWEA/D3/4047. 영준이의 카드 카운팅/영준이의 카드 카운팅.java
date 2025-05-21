import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			String[] input = br.readLine().split("");
			
			Set<String>[] set = new HashSet[4];
			
			for(int i=0; i<4; i++) 
				set[i] = new HashSet<String>();
			
			StringBuilder sb = new StringBuilder();
			
			boolean error = false;
			for(int i=0; i<input.length; i+=3) {
				String T = input[i];
				String num = input[i+1]+input[i+2];
				
				if(T.equals("S")) {
					if(set[0].contains(num)) {
						error = true;
						break;
					}
					set[0].add(num);
				}
				else if(T.equals("D")) {
					if(set[1].contains(num)) {
						error = true;
						break;
					}
					set[1].add(num);
				}
				else if(T.equals("H")) {
					if(set[2].contains(num)) {
						error = true;
						break;
					}
					set[2].add(num);
				}
				else if(T.equals("C")) {
					if(set[3].contains(num)) {
						error = true;
						break;
					}
					set[3].add(num);
				}
			}
			if(!error) {
				sb.append(13-set[0].size()).append(" ")
				.append(13-set[1].size()).append(" ")
				.append(13-set[2].size()).append(" ")
				.append(13-set[3].size());	
			}
			else
				sb.append("ERROR");
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}


