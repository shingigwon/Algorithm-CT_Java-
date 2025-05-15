import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			String[] nums = br.readLine().split(" ");
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=0; i<nums.length; i++)
				q.add(Integer.parseInt(nums[i]));

			
			int idx = 1;
			while(true) {
				int poll = q.poll();
				int res = poll-idx;
				
				if(res<=0) {
					q.add(0);
					break;
				}
				
				else
					q.add(res);
				idx%=5;
				idx++;
			}
			
			Iterator<Integer> iter = q.iterator();
			StringBuilder sb = new StringBuilder();
			
			while(iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
				
			System.out.printf("#%d %s\n",T,sb.toString());			
		}

		br.close();
	}
}	




