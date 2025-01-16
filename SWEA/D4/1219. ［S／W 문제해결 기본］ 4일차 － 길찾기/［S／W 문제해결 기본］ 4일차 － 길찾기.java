import java.io.*;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 0; t < 10; t++) {
			st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int Len = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[100];
			
			for(int i=0; i<100; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<Len; i++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				arr[y].add(x);
			}
			boolean check = DFS(0);
			System.out.printf("#%d %d\n", T, check ? 1 : 0);

		}
		br.close();
	}
	
	static boolean DFS(int V) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(V);
		
		while(!stack.isEmpty()) {
			int pop = stack.pop();
			if(pop == 99)
				return true;
			
			for(int next:arr[pop]) {
				stack.push(next);
			}
		}
		return false;
	}
}
