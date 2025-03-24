import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean check = true;

			for (char ch : input.toCharArray()) {

				if (ch == '(')
					stack.push(ch);

				else {
					if (stack.isEmpty()) {
						check = false;
						break;
					}

					else if (stack.peek() == '(')
						stack.pop();
				}
			}
			System.out.println(check && stack.isEmpty() ? "YES" : "NO");
		}

		br.close();
	}
}
