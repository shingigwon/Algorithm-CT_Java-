import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			int idx = 1;
			for(int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				for(int j=L-1; j<R; j++) 
					arr[j] = idx; 
				
				idx++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i : arr)
				sb.append(i).append(" ");
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}



