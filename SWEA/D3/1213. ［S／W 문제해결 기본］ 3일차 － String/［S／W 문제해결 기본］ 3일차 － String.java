import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String input = br.readLine();
			
			int cnt = 0;
			int end = 0;
			
			while(true) {
				int idx = input.indexOf(find, end);
				if(idx==-1)
					break;
				cnt++;
				end = idx+find.length();
			}
			
			System.out.printf("#%d %d\n", T, cnt);
		}
		br.close();
	}
}