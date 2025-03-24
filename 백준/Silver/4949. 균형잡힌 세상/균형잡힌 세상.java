import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = br.readLine();
			if (input.equals("."))
				break;

			Stack<Character> stack = new Stack<Character>();
			int i = 0;
			boolean check = true;

			while (i < input.length()) {
				char ch = input.charAt(i);
				if (ch == '(' || ch == '[') 
					stack.push(ch);
				
				if (ch == ')') {
					if (!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else {
						check = false;
						break;
					}
				}

				if (ch == ']') {
					if (!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else {
						check = false;
						break;
					}
				}
				i++;
			}
			System.out.println(check&&stack.isEmpty() ? "yes" : "no");
		}

		br.close();
	}
}
