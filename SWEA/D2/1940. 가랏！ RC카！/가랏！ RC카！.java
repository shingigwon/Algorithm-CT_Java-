import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int dist = 0;
			int cur = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				
				if(cmd==0) {
					
				}
				else {
					int ms = Integer.parseInt(st.nextToken());
					
					if(cmd==1) 
						cur+=ms;
					else
				        cur = Math.max(0, cur-ms);
				}
				
				dist+=cur;
					
			}
			System.out.printf("#%d %d\n",t, dist);
		}
		br.close();
	}
}