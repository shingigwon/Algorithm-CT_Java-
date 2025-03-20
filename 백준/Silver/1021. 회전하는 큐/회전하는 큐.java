import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			q.add(i);

		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			int mid = q.size() / 2;

			if (q.indexOf(idx) <= mid) {
				while (idx != q.get(0)) {
					q.addLast(q.pollFirst());
					cnt++;
				}
			} else {
				while (idx != q.get(0)) {
					q.addFirst(q.pollLast());
					cnt++;
				}
			}
			q.poll();
		}

		System.out.println(cnt);
		br.close();
	}

}
