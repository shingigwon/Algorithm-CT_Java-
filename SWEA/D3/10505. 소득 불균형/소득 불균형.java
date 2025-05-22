import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) 
				arr[i]=Integer.parseInt(st.nextToken()); 
			
			int avg = Arrays.stream(arr).sum()/N;
			int ret = 0;
			
			for(int i : arr) {
				if(i<=avg)
					ret++;
			}
			
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
}

