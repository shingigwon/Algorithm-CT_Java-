import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=TC; t++) {
			String input = br.readLine();
			
			int ret = 0;
			Stack<Character> stack = new Stack<Character>();
			char last = ' ';
			for(char ch : input.toCharArray()) {
				if(ch=='(')
					stack.add(ch);
				
				else {
					stack.pop();
					
					if(last == ')') 
						ret++;
					else 
						ret+=stack.size();
				}
				last = ch;
			}
			System.out.printf("#%d %d\n", t, ret);
		}
		br.close();
	}
}
