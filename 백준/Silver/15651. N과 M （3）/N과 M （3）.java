import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] vis;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int [M];
		
		Permutation(0);
		System.out.println(sb.toString());
		br.close();
	}
	static void Permutation(int cnt) {
		if(cnt==M) {
			for(int i : arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}

		
		for(int i=1; i<=N; i++) {
			arr[cnt] = i;
			Permutation(cnt+1);
		}
	}
}
