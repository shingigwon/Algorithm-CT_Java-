import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		for(char ch : input.toCharArray()) 
			sb.append(ch-64).append(" ");
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
