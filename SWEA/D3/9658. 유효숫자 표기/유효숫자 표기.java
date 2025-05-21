import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			int len = sb.length()-1;
			
			sb.insert(1, ".");
			String input = String.format("%.1f", Double.parseDouble(sb.toString()));
			
			double d = Double.parseDouble(input);
			
			if(d%10==0) {
				d/=10;
				len++;
			}
			
			StringBuilder ret = new StringBuilder();
			ret.append(d).append("*").append("10^").append(len);
			
			System.out.printf("#%d %s\n",t, ret.toString());
		}
		br.close();
	}
}



