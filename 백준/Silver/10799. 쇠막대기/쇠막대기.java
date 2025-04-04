import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int res = 0;
		char last = ' ';
		for(char ch : input.toCharArray()) {
			if(ch=='(') 
				stack.push(ch);
			
			else if(ch==')') {
				stack.pop();
				
				if(last=='(') 
					res+=stack.size();
				
				else
					res++;
			}
			last = ch;
		}
		
		System.out.println(res);
		br.close();
		
	}
}
