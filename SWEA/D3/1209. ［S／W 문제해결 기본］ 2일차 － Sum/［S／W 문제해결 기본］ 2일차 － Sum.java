import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			int[][] map = new int[100][100];
			int max = 0;
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());;
				}
			}
			max = Math.max(checkC(map),checkWH(map));
			
			System.out.printf("#%d %d\n",T, max);
		}
		br.close();
	}
	
	
	static int checkWH(int[][] map) {
		int max = 0;
		for(int i=0; i<100; i++) {
			int w = 0;
			int h = 0;
			for(int j=0; j<100; j++) {
				w+=map[i][j];
				h+=map[j][i];
			}
			max = Math.max(max, Math.max(w, h));
		}
		return max;
	}
	
	static int checkC(int[][] map) {
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<100; i++) {
			sum1+= map[i][i];
			sum2+= map[i][99-i];
		}
		
		return Math.max(sum1, sum2);
	}
}