import java.io.*;
import java.util.*;

public class Main {
	static int [] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //3
		int M = Integer.parseInt(st.nextToken()); //1
		
		arr = new int[M];
		visited = new boolean[N];
		
		DFS(N,M,0);
		System.out.println(sb.toString());
		br.close();
	}
	
	static void DFS(int N, int M, int depth) {
		if(depth==M) {
			for(int next:arr)
				sb.append(next).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[depth] = i+1;		 	
				DFS(N,M,depth+1);		
				visited[i]=false;
			}
		}
	}
	
}
