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
			int K = Integer.parseInt(st.nextToken());
			
			Integer [] arr = new Integer[N];
			int ret = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				arr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr, Collections.reverseOrder());
			
			for(int i=0; i<K; i++) 
				ret+=arr[i];
			
			System.out.printf("#%d %d\n",t, ret);
		}
		
		br.close();
	}
}

