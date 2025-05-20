import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			for(int i=0; i<N; i++) {
				if(i==N-1)
					cnt+=arr[i];
				cnt+=arr[i]+1;
			}
			System.out.printf("#%d %d\n",t,cnt);
		}
		
		br.close();
	}
}

