import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(char ch : input.toCharArray()) {
				switch(ch) {
				case 'b':
					sb.append("d");
					break;
				case 'd':
					sb.append("b");
					break;
				case 'p':
					sb.append("q");
					break;
				case 'q':
					sb.append("p");
					break;
				}
			}
			sb.reverse();
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}


