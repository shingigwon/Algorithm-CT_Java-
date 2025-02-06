import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			 case "push":
				 int num = Integer.parseInt(st.nextToken());
				 stack.push(num);
			 	break;
			 case "top":
				 if(stack.isEmpty())
					 sb.append("-1").append("\n");
				 else
					 sb.append(stack.peek()).append("\n");
				 break;
			 case "size":
				 sb.append(stack.size()).append("\n");
				 break;
			 case "empty":
				 if(stack.isEmpty())
					 sb.append("1").append("\n");
				 else
					 sb.append("0").append("\n");
				 break;
			 case "pop":
				 if(stack.isEmpty())
					 sb.append("-1").append("\n");
				 else
					 sb.append(stack.pop()).append("\n");
				 break;
				 
			}
		}
		System.out.println(sb.toString());
		
		br.close();

	}

}

