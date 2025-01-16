import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for (int i = 0; i < N; i++) {
				boolean check = false;
				for (int j = 0; j < N; j++) {
					if(arr[j][i]==1) {
						check = true;
					}
					
					else if(arr[j][i]==2&&check){
						count++;
						check = false;
					}
				}
			}

			System.out.printf("#%d %d\n", t, count);
			
		}
		br.close();
	}
}