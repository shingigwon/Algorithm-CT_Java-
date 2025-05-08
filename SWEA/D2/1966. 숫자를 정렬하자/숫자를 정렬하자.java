import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			List<Integer> list = new ArrayList<Integer>();
			
			for(int i=0; i<N; i++) 
				list.add(Integer.parseInt(st.nextToken()));
			
			Collections.sort(list);
			for(int n : list)
				sb.append(n).append(" ");
			
			
			System.out.printf("#%d %s\n",t, sb.toString());
		}
		br.close();
	}
	
}