import java.io.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] arr = {".#..","#.#."};
				
		for(int tc = 1; tc<=T; tc++) {
			char[] input = br.readLine().toCharArray();

			StringBuilder[] res  = new StringBuilder[5];
			for(int i=0; i<5; i++) {
				res[i] = new StringBuilder();
			}
			
			res[0].append("..#..");
			res[1].append(".#.#.");
			res[2].append("#.").append(input[0]).append(".#");
			res[3].append(".#.#.");
			res[4].append("..#..");
			
			for(int i=1; i<input.length; i++) {
				res[0].append(arr[0]);
				res[1].append(arr[1]);
				res[2].append(".").append(input[i]).append(".#");
				res[3].append(arr[1]);
				res[4].append(arr[0]);
			}

			for(int i=0; i<5; i++) {
				sb.append(res[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
