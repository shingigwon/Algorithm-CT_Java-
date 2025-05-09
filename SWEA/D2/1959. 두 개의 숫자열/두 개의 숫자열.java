import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)  
				B[i] = Integer.parseInt(st.nextToken());

			int res = 0;
			
			if(N>M) {
				int[] temp = A;
				A=B;
				B=temp;
				
				int tmp = N;
				N=M;
				M=tmp;
			}
			
			for(int i=0; i<=M-N; i++) {
				int sum = 0;
				for(int j=0; j<N; j++) {
					sum+=A[j]*B[i+j];
				}
				res = Math.max(sum, res);
			}
			
			System.out.printf("#%d %d\n",t, res);
		}
		br.close();
	}
}