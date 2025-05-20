import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write("#" + t + " " + (N % 2 == 0 ? "Alice" : "Bob") + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
