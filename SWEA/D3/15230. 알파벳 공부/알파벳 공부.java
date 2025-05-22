import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String eng = "abcdefghijklmnopqrstuvwxyz";
		
		for (int t = 1; t <= TC; t++) {
			String input = br.readLine();

			int cnt = 0;
			for(int i=0; i<input.length(); i++) {
				char ch1 = eng.charAt(i);
				char ch2 = input.charAt(i);
				
				if(ch1==ch2)
					cnt++;
				else
					break;
				
			}
			System.out.printf("#%d %d\n",t, cnt);
		}
		br.close();
	}
}

