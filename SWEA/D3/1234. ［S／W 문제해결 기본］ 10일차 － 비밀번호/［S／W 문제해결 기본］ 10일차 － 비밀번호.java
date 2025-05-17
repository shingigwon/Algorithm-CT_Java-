import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(char ch : s.toCharArray()) {
				if(!stack.isEmpty()&& stack.peek()==ch)
					stack.pop();
				else
					stack.push(ch);
			}
			StringBuilder sb = new StringBuilder();
			Iterator<Character> iter = stack.iterator();
			while(iter.hasNext())
				sb.append(iter.next());
			
			System.out.printf("#%d %s\n", t, sb.toString());
		}
		br.close();
	}
}


/*




*/