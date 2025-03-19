import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		sb.append(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int cur = sb.length();

		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");

			switch (cmd[0]) {
			case "L":
				cur--;
				cur = cur <= 0 ? 0 : cur;
				break;
			case "D":
				cur++;
				cur = cur >= sb.length() ? sb.length() : cur;
				break;

			case "B":
				if (cur - 1 < 0)
					break;
				cur--;
				cur = cur <= 0 ? 0 : cur;
				sb.deleteCharAt(cur);
				break;

			case "P":
				sb.insert(cur, cmd[1]);
				cur++;
				cur = cur >= sb.length() ? sb.length() : cur;
				break;
			}
		}

		System.out.println(sb.toString());
		br.close();
	}
}
