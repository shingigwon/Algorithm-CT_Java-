import java.io.*;
import java.util.*;

public class Main {
	static int N,S;
	static int[] nums;
	static int[] arr;
	static int ret = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) 
			perm(0, 1, i);			
		
		
		
		System.out.println(ret);
		br.close();
	}
	
	static void perm(int cnt, int start, int m) {
		if(cnt == m) {
			int sum = 0;
			for(int i : arr) 
				sum+=i;
			
			if(sum==S)
				ret++;
			return;
		}
		
		for(int i = start; i<=N; i++) {
			arr[cnt] = nums[i];
			perm(cnt+1, i+1,m);
		}
			
	
	}
}




