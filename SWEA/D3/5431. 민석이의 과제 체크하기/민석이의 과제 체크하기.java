import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Set<Integer> set = new TreeSet<Integer>();
			
			for(int i=1; i<=N; i++) 
				set.add(i);
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) 
				set.remove(Integer.parseInt(st.nextToken()));
			
			
			StringBuilder sb = new StringBuilder();
			
			for(int i : set)
				sb.append(i).append(" ");
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
}



