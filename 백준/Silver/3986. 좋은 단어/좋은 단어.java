import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			for(char ch : input.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == ch) 
					stack.pop();
				
				 else 
					stack.push(ch);
			}
			
			if(stack.isEmpty()) cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}
}
