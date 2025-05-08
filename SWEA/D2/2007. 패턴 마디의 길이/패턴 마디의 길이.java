import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String input = br.readLine();
			
			for(int i=1; i<input.length(); i++) {
				if(input.substring(0,i).equals(input.substring(i, i*2))) {
					System.out.printf("#%d %d\n",t,i);
					break;
				}
			}
		}
		br.close();
	}
}



