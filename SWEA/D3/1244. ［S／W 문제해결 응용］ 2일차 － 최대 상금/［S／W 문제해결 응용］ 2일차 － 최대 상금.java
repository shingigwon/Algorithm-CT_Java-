import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());

			String nums = st.nextToken();
			int swapCount = Integer.parseInt(st.nextToken());

			int max = Max(nums, swapCount);

			System.out.printf("#%d %d\n", i, max);
		}
		br.close();

	}

	static int Max(String nums, int swapCount) {
		int[] max = {0};
		char[] numbers = nums.toCharArray();
		BackTracking(numbers, swapCount, 0, max);
		return max[0];
		
	}
	
	static void BackTracking(char[] numbers, int swapCount, int start, int[] max) {
		if(swapCount==0) {
			int curmax = Integer.parseInt(new String(numbers));
			max[0] = Math.max(max[0], curmax);
			return;
		}
		
		for(int i=start; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				Swap(numbers, i, j);
				BackTracking(numbers, swapCount-1, i, max);
				Swap(numbers, i, j);
			}
		}
	}
	
	static void Swap(char[] numbers, int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
