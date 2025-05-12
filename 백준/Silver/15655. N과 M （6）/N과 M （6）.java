import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] nums;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [M];
		
		sb = new StringBuilder();
		nums = new int[N+1];
		st =  new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) 
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		Combination(0, 1);
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static void Combination(int cnt, int start) {
		if(cnt == M) {
			for(int i : arr)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<=N; i++) {
			arr[cnt]=nums[i];
			Combination(cnt+1, i+1);
		}
	}
	
	
}
