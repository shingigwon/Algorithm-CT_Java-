import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int count = 1;
		for (int i = 0; i < N; i++) {
			sum += arr[i];

			if (i >= X - 1) {
				if (sum > max) {
					max = sum;
					count = 1;
				} else if (sum == max)
					count++;

				sum -= arr[i - X + 1];
			}
		}

		if(max==0)
			System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(count);
		}
		br.close();
	}

}
