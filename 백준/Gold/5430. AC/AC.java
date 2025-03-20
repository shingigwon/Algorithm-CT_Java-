import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			String cmds = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();

			Deque<Integer> q = new ArrayDeque<Integer>();
			if (N > 0) {
				input = input.substring(1, input.length() - 1); // 대괄호 제거
				StringTokenizer st = new StringTokenizer(input, ",");

				while (st.hasMoreTokens())
					q.add(Integer.parseInt(st.nextToken()));
			}

			boolean rev = false;
			boolean check = false;

			for (char cmd : cmds.toCharArray()) {
				if (cmd == 'R')
					rev = !rev;

				else if (cmd == 'D') {
					if (q.isEmpty()) {
						sb.append("error");
						check = true;
						break;
					}
					if (rev)
						q.removeLast();
					else
						q.removeFirst();
				}
			}

			if (!check) {
				sb.append("[");
				while (!q.isEmpty()) {
					sb.append(rev ? q.removeLast() : q.removeFirst());
					if (!q.isEmpty())
						sb.append(",");
				}
				sb.append("]");
			}

			System.out.println(sb.toString());
		}
		br.close();
	}

}
