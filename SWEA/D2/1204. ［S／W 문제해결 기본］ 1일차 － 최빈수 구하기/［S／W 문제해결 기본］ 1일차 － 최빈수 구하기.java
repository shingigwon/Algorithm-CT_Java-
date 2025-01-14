import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int idx = Integer.parseInt(br.readLine());
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 1000; j++) {
				int num = Integer.parseInt(st.nextToken());
				int count = map.getOrDefault(num, 0) + 1;

				map.put(num, count);
			}
			int maxValue = Integer.MIN_VALUE;
			int maxNum = -1; 
			
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int key = entry.getKey();
                int value = entry.getValue();
                
				if (value > maxValue || (value == maxValue && key > maxNum)) {
                    maxValue = value;
                    maxNum = key;
                }
			}
			
			System.out.printf("#%d %d\n",idx,maxNum);

		}

		br.close();
	}

}



