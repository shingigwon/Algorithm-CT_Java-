import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> set = new HashSet<Integer>();
			
			int num=0;
			int i = 1;
			while(set.size()<10) {
				num = i++*N;
				
				String.valueOf(num)
				.chars()
				.map(c->c-'0')
				.forEach(set::add);
			}
			
			System.out.printf("#%d %d\n",t, num);
		}
		br.close();
	}
}