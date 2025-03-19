import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		Arrays.fill(arr, 0);
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> idxStack = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int h = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()&&stack.peek()<h) {
				stack.pop();
				idxStack.pop();
			}
			if(!stack.isEmpty())
				arr[i] = idxStack.peek()+1;
			
			stack.push(h);
			idxStack.push(i);
		}
		
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		br.close();
	}
}
