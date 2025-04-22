import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			int idx=0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				char ch = st.nextToken().charAt(0);
				int K = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<K; j++) {
					sb.append(ch);
					idx++;
					
					if(idx%10==0)
						sb.append("\n");
					
				}
				
			}
			System.out.printf("#%d\n%s\n",t, sb.toString());
		}
		br.close();
	}
}


