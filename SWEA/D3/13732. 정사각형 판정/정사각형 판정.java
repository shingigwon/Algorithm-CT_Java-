import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[N][N];
			List<int[]> list = new ArrayList<>();
			boolean ret = true;

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					if (input.charAt(j) == '#') {
						map[i][j] = true;
						list.add(new int[] { i, j });
					}
				}
			}

			int hMax = list.stream().mapToInt(arr -> arr[0]).max().getAsInt();
			int hMin = list.stream().mapToInt(arr -> arr[0]).min().getAsInt();
			
			int wMax = list.stream().mapToInt(arr -> arr[1]).max().getAsInt();
			int wMin = list.stream().mapToInt(arr -> arr[1]).min().getAsInt();

			if (hMax - hMin != wMax - wMin)
				ret = false;
			
			else {
				for (int i=hMin; i<=hMax; i++) {
					for (int j=wMin; j<=wMax; j++) {
						if (!map[i][j]) {
							ret = false;
							break;
						}
					}
				}
			}

			System.out.printf("#%d %s\n", t, ret ? "yes" : "no");
		}
		br.close();
	}
}

