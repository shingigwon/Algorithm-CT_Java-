import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int i = 1; i < T+1; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for(int j=2; j<N-2; j++) {
				int max = Integer.MIN_VALUE;
				
				for(int k=j-2; k<=j+2; k++) {
					if(k==j)
						continue;
					else if(max<arr[k])
						max = arr[k];
				}
				if(arr[j]>max)
					sum+=arr[j] - max;
			}
			System.out.printf("#%d %d\n",i,sum);

		}

		br.close();
	}

}