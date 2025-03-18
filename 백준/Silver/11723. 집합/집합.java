import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Set<Integer> list = new HashSet<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int n = 0;
			
			if (st.countTokens() == 1)
				n = Integer.parseInt(st.nextToken());
				

			switch (cmd) {
			case "add":
				list.add(n);
				break;
			case "remove":
				list.remove(n);
				break;
			case "toggle":
				if (list.contains(n))
					list.remove(n);
				else
					list.add(n);
				break;
			case "empty":
				list.clear();
				break;
			case "check":
				if (list.contains(n))
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "all":
				for (int s = 1; s <= 20; s++)
					list.add(s);
				break;
			}

		}
		System.out.println(sb.toString());
		br.close();
	}

}
