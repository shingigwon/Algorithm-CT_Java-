import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		boolean[] s = new boolean[N];
		
		for(int i=0; i<N; i++) {
			s[i] = st.nextToken().equals("1");
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			switch (a) {
			case 1:
				s[b] = c > 0 ? true : false;
				break;
			case 2:
				for (int k = b; k < c; k++) {
					s[k] = !s[k];
				}
				break;
			case 3:
				for (int k = b; k < c; k++) {
					s[k] = false;
				}
				break;
			case 4:
				for (int k = b; k < c; k++) {
					s[k] = true;
				}
				break;
			}

		}
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j<s.length; j++) {
			sb.append(s[j]==true?"1":"0").append(" ");
		}
		System.out.println(sb.toString().trim());
		
		br.close();
	}

}
