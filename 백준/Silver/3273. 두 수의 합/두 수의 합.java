import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int X = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		
		int start = 0;
		int end = N - 1;
		int count = 0;

		while (start < end) {
			if (arr[start]+arr[end] < X) {
				start++;
			} else if (arr[start]+arr[end] > X) {
				end--;
			} else if (arr[start]+arr[end]== X) {
				start++;
				end--;
				count++;
			}
		}
		
		System.out.println(count);

		br.close();
	}

}
