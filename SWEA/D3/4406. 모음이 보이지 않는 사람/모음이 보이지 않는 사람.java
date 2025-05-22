import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String[] vowels = {"a", "e", "i","o","u"};

		for (int t = 1; t <= TC; t++) {
			String input = br.readLine();
			
			for(int i=0; i<vowels.length; i++)
				input = input.replaceAll(vowels[i], "");
			
			System.out.printf("#%d %s\n",t, input);
		}
		br.close();
	}
	
}




