import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();

		Set<String> set = new HashSet<String>();

		for (int i = 0; i < N; i++)
			set.add(br.readLine());

		if (game.equals("Y"))
			System.out.println(set.size());

		else if (game.equals("F"))
			System.out.println(set.size() / 2);

		else if (game.equals("O"))
			System.out.println(set.size() / 3);

		br.close();
	}
}
