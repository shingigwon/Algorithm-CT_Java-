import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();	 
			int[][] arr = new int[N+1][N+1];
			
			arr[1][1] = 1;
			for(int i=2; i<=N; i++) {
				for(int j=1; j<=i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			
			System.out.printf("#%d", t);
			
			for(int[] k: arr) {
				for(int k1 : k) {
					if(k1!=0)
						System.out.print(k1+" ");
				}
				System.out.println();
			}
			
		}
		br.close();
	}
}
