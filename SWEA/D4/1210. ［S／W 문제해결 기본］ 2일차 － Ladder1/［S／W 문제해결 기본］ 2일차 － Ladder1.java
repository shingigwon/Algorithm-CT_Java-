import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;

		for (int t = 0; t < T; t++) {
			int idx = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];

			int start = -1;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
					if (num == 2)
						start = j;
				}
			}
			int y = 99;
			while (y > 0) {
				if (start < 99 && arr[y][start + 1] == 1) {
					while (start < 99 && arr[y][start + 1] == 1) {
						start++;
					}
				} else if (start > 0 && arr[y][start - 1] == 1) {
					while (start > 0 && arr[y][start - 1] == 1)
						start--;
				}

				y--;
			}

			System.out.printf("#%d %d\n", idx, start);
		}
		br.close();
	}

}
