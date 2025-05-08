import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<arr.length; i++) {
				sb.append(N/arr[i]).append(" ");
				N%=arr[i];
			}
			System.out.printf("#%d\n%s\n",t, sb.toString());
		}
		br.close();
	}
	
}