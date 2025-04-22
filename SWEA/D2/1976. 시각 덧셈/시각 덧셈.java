import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] input = br.readLine().split(" ");
			
			int h = Integer.parseInt(input[0]) + Integer.parseInt(input[2]);
			int m = Integer.parseInt(input[1]) + Integer.parseInt(input[3]);
			
			h = m>60?h+1:h;
			h = h%12==0?h=12:h%12;
			
			System.out.printf("#%d %d %d\n", t, h, m%60);
		}
		br.close();
	}
}


