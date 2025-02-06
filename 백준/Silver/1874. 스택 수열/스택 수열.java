import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int num=1;
		int idx=0;
		while(idx<N) {
			if(arr[idx]>=num) {
				stack.push(num);
				num++;
				sb.append("+").append("\n");
			}
			else if(stack.peek()==arr[idx]) {
				stack.pop();
				idx++;
				sb.append("-").append("\n");
			}
			else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();

	}

}
