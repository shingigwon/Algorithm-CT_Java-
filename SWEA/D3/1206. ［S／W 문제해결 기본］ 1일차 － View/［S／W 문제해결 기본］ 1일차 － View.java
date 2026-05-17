import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = 0;
			for(int i=2; i<arr.length-2; i++) {
				int max = Math.max(
						Math.max(arr[i-2], arr[i-1]),
						Math.max(arr[i+2], arr[i+1])
						);
				
				if(max>=arr[i]) continue;
				
				res += arr[i]-max;
			}
			
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		System.out.println(sb.toString());
	}	
}
