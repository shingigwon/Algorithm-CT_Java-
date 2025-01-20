import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0)
				stack.pop();

			else
				stack.add(num);

		}
		int sum = 0;

		if (!stack.isEmpty()) {
			for (int n : stack) {
				sum += n;
			}
			System.out.println(sum);
		} else
			System.out.println(sum);

	}

}
