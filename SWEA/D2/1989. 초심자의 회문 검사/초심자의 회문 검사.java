import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder(input);
			
			int check = input.equals(sb.reverse().toString())?1:0;
			
			System.out.printf("#%d %d\n", t, check);
		}
		br.close();
	}
}


