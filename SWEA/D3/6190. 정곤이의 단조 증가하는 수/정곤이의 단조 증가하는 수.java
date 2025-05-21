import java.io.*;
import java.util.*;

public class Solution {
	static int N,ret;
	static int[] nums, arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			arr = new int[2];
			ret = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				nums[i] = Integer.parseInt(st.nextToken()); 
			
			comb(0,0);
			System.out.printf("#%d %s\n",t, ret);
		}
		br.close();
	}
	
	static void comb(int depth, int idx) {
		if(depth == 2) {
			int sum = 1;
			boolean chk = true;
			for(int i:arr)
				sum*=i;
			
			String str = Integer.toString(sum);
			
			for(int i=1; i<str.length(); i++) {
				if(str.charAt(i-1)>str.charAt(i)) {
					chk = false;
					break;
				}
			}
			if(chk)
				ret = Math.max(ret, sum);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			arr[depth] = nums[i];
			comb(depth+1, i+1);
		}
	}
}



