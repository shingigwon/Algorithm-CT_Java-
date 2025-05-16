import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			String bit = br.readLine();
			int cnt = 0;
			boolean isChk = false;
			
			for(char ch : bit.toCharArray()) {
				if((ch=='1' && !isChk)||(ch=='0'&&isChk)) {
					isChk = !isChk;
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", t, cnt);
		}
		br.close();
	}
}