import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int ret = 0;
			
			if(L>X)
				ret = L-X;
			
			else if(X>U)
				ret = -1;
			
			else 
				ret = 0;
            
			System.out.printf("#%d %d\n",t, ret);
		}
		
		br.close();
	}
}