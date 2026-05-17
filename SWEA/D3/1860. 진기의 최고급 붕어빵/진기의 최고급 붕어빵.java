import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			boolean isChk = true;

			for (int i = 0; i < N; i++) {
				
			    int made = (arr[i] / M) * K;
			    
			    if (made < i + 1) {
			    	isChk = false;
			        break;
			    }
			}
			
			sb.append("#").append(tc).append(" ").append(isChk?"Possible":"Impossible").append("\n");
		}
		
		System.out.println(sb.toString());
	}	
}
