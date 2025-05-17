import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int T = scan.nextInt();
			int N = scan.nextInt();
			int M = scan.nextInt();
			
			
			int num = N;
			int idx = 1;
			while(idx<M) {
				num*=N;
				idx++;
			}
			
			System.out.printf("#%d %d\n", T, num);
		}
	}
}