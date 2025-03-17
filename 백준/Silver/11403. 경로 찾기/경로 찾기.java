import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] list;
	static int[][] res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		res = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) 
			list[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(res[i-1], 0);
			for(int j=1; j<=N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1)
					list[i].add(j);
			}
		}
		
		for(int i=1; i<=N; i++) {
			DFS(i);
		}
		
		for(int i=1; i<res.length; i++) {
			for(int j=1; j<res[i].length; j++)
				sb.append(res[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	static void DFS(int idx) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(idx);
		
		while(!stack.empty()) {
			int pop = stack.pop();
			
			for(int next:list[pop]) {
				if(res[idx][next]!=1) {
					res[idx][next] = 1;
					stack.push(next);
				}
				
			}
			
		}
	}
}
