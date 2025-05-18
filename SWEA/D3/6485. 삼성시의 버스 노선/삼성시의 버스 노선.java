import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[5002];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				for(int j=A; j<=B; j++) 
					arr[j]++;
				
			}
			int P = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<P; i++) {
				int C = Integer.parseInt(br.readLine());
				sb.append(arr[C]).append(" "); 
			}
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		
		br.close();
	}
}
