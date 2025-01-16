import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					list.add(i);
				}
			}
			
			int min = Integer.MAX_VALUE;
			int result = -1;
			
			for(int i=0; i<list.size(); i++) {
				int y = 1;
				int count = 1;
				int idx = list.get(i);
				int start = idx;
				
				while (y < 100) {
					if (start > 0 && arr[y][start - 1] == 1) {
						while (start > 0 && arr[y][start - 1] == 1) {
							start--;
							count++;
						}
					} 
					else if (start < 99 && arr[y][start + 1] == 1) {
						while (start < 99 && arr[y][start + 1] == 1) {
							start++;
							count++;
						}
					}
					y++;
					count++;
				}
				if(min>count) {
					min = count;
					result = idx;
				}
			}
			System.out.printf("#%d %d\n",T,result);

		}
		br.close();
	}

}
