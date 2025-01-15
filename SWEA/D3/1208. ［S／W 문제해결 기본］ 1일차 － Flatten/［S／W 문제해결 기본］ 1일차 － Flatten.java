import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int t=1; t<T+1; t++) {
			List<Integer> list = new ArrayList<>(100);
			int count = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<count; i++) {
				int maxidx = list.indexOf(Collections.max(list));
				int minidx = list.indexOf(Collections.min(list));
				list.set(maxidx, list.get(maxidx)-1);
				list.set(minidx, list.get(minidx)+1);
			}
			
			int result = Collections.max(list)-Collections.min(list);
            System.out.printf("#%d %d\n", t, result);
		}
		
		
		
		br.close();
	}
}
