import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static int M;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());//10
			N = Integer.parseInt(st.nextToken());//8
			int K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());//10
				int X = Integer.parseInt(st.nextToken());//8
				graph[X][Y]=1;
			}
			
			int result = 0;
	        for(int j = 0; j < N; j++) {
	            for (int k = 0; k < M; k++) {
	                if (dfs(j,k)) {
	                    result += 1;
	                }
	            }
	        }
			
	        System.out.println(result);
		}
		br.close();
	}
	
	public static boolean dfs(int x, int y) {
       if (x <= -1 || x >= N || y <= -1 || y >= M) {
           return false;
       }
       if (graph[x][y] == 1) {
           graph[x][y] = 2;
           dfs(x-1, y); //상
           dfs(x, y-1); // 좌
           dfs(x+1, y); // 하
           dfs(x, y+1); // 우
           return true;
       }
       return false;
    }
}