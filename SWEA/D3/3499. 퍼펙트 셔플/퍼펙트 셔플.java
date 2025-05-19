import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			
			StringBuilder sb = new StringBuilder();
			
			int len = N%2==1?N/2+1:N/2;
			int idx = len;
			for(int i=0; i<len; i++) {
				sb.append(cards[i]).append(" ");
				if(idx==N)
					break;
				sb.append(cards[idx++]).append(" ");
			}
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		
		br.close();
	}
}




