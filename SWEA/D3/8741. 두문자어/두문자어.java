import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			String[] input = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<input.length; i++) 
				sb.append(Character.toUpperCase(input[i].charAt(0)));
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}


