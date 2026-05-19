import java.io.*;

class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String a = br.readLine();
			String b = br.readLine();

			int cnt = 0;
			for(int i=0; i<N; i++) {
				if(a.charAt(i) == b.charAt(i))
					cnt++;
			}
			
			sb.append("#").append(tc).append(" ")
			.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
