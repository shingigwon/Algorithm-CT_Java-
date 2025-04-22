import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			String[] input = br.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			int N = Integer.parseInt(input[2]);
			
			int cnt=0;
			while(true) {
				if(A>B)
					B+=A;
				else
					A+=B;
				
				cnt++;
				
				if(A>N || B>N)
					break;
				
			}
			System.out.println(cnt);
			
		}
		br.close();
	}
}