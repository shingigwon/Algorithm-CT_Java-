import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] nums = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				nums[i] = Integer.parseInt(st.nextToken());  
			
			
			int up = 0;
			int down = 0;
			
			for(int i=1; i<N; i++) {
				down = Math.max(nums[i - 1] - nums[i], down);
				up = Math.max(nums[i] - nums[i - 1], up);				
			}
			
			System.out.printf("#%d %d %d\n",t, up, down);
		}
		br.close();
	}
}

