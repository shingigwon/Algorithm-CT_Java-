import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = arr[0];
		int count = 0;
		while (end < N) {
			if (sum < M) {
				end++;
				sum += arr[end];
			} else if (sum > M) {
				sum -= arr[start];
				start++;
			} else if (sum == M) {
				end++;
				sum+=arr[end];
				count++;
			}
		}
		System.out.println(count);

		br.close();
	}

}
