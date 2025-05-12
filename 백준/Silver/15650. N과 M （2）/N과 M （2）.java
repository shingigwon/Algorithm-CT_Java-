import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [M];
		
		Combination(0,1);
		
		br.close();
	}
	static void Combination(int cnt, int start) {
		if(cnt==M) {
			for(int i : arr)
				System.out.print(i+" ");
			System.out.println();
			return;
		}

		
		for(int i=start; i<=N; i++) {
			arr[cnt] = i;
			Combination(cnt+1, i+1);
		}
	}
}
