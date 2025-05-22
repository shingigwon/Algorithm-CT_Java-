import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int ret = 1;
			while(true) {
				N=N-(2*D+1);
				
				if(N<=0)
					break;
				ret++;
				
			}
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
}

