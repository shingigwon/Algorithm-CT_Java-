import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[12];
			
			while(N>1) {
				//11
				while(N%11==0) {
					arr[11]++;
					N/=11;
				}
				//7
				while(N%7==0) {
					arr[7]++;
					N/=7;
				}
				//5
				while(N%5==0) {
					arr[5]++;
					N/=5;
				}
				//3
				while(N%3==0) {
					arr[3]++;
					N/=3;
				}
				//2
				while(N%2==0) {
					arr[2]++;
					N/=2;
				}
			}
			System.out.printf("#%d %d %d %d %d %d\n",t, arr[2], arr[3], arr[5], arr[7], arr[11]);
		}
		br.close();
	}
}