import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int[][] turn1 = turn(map,N);
			int[][] turn2 = turn(turn1,N);
			int[][] turn3 = turn(turn2,N);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			
			for(int i=0; i<N; i++) {
				sb.append(printRow(turn1,i)).append(" ")
				.append(printRow(turn2,i)).append(" ")
				.append(printRow(turn3,i)).append("\n");
				
			}
			
			System.out.print(sb.toString());
		}
		br.close();
	}
	static int[][] turn(int[][] map, int N){
		int[][] turnMap = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) 
				turnMap[i][j] = map[N-1-j][i];
		}
		
		return turnMap;
	}
	
	static String printRow(int[][] map, int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<map.length; i++) 
			sb.append(map[cnt][i]);
		
		return sb.toString() ;
	}
	
}