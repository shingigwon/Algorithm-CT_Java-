import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());

			char[] arr = br.readLine().toCharArray();
			boolean check = false;
			check = isValid(arr, N);

			System.out.printf("#%d %d\n", t, check ? 1 : 0);

		}
		br.close();
	}

	static boolean isValid(char[] arr, int N) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < N; i++) {
			if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(' || arr[i] == '<') {
				stack.push(arr[i]);
			} else if (arr[i] == '}' || arr[i] == ']' || arr[i] == ')' || arr[i] == '>') {
				if (stack.isEmpty()) {
					return false;
				}

				char top = stack.pop();
				if (!
					(  (top == '{' && arr[i] == '}') 
					|| (top == '[' && arr[i] == ']') 
					|| (top == '(' && arr[i] == ')')
					|| (top == '<' && arr[i] == '>'))) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
