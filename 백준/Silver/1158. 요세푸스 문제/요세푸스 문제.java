import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		ListIterator<Integer> iter = list.listIterator();
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (!list.isEmpty()) {
			for (int i = 0; i < K; i++) {
				if (!iter.hasNext())
					iter = list.listIterator();

				iter.next();
			}
			sb.append(iter.previous());

			iter.next();
			iter.remove();

			if (!list.isEmpty())	sb.append(", ");
		}

		sb.append(">");
		System.out.println(sb.toString());
        br.close();
	}
}
