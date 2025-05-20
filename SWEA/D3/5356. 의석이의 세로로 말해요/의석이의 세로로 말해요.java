import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringBuilder sb = new StringBuilder();
			char[][] arr = new char[15][15];
			
			for(int i=0; i<5; i++) {
				String input = br.readLine();	
				for(int j=0; j<input.length(); j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					char ch = arr[j][i]; 
					if(!(Character.isLowerCase(ch)||Character.isUpperCase(ch)||Character.isDigit(ch)))
						continue;
					sb.append(ch);
				}
				
			}
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}

