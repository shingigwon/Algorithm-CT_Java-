import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			String input = br.readLine();
			
			int n = Integer.parseInt(input.substring(input.length()-1));
			
			String ret = n%2==0?"Even":"Odd";
			
			System.out.printf("#%d %s\n",t, ret);
		}
		br.close();
	}
}


