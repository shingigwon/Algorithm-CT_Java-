import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sb.setLength(0);
			
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			for(int j=0; j<S.length(); j++) {
				char ch = S.charAt(j);
				for(int k=0; k<R; k++) {
					sb.append(ch);
				}
			}
			System.out.println(sb.toString());
		}
		
		br.close();
	}
}
