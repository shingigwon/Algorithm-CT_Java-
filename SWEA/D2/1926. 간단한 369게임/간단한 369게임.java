import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			int count = 0;
			String str = Integer.toString(i);
			
			
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				
				if (ch == '3' || ch == '6' || ch == '9') {
					count++;
				}
			}
			
			
			if(count==0) sb.append(i);
			
			else {
				for(int j=0; j<count; j++)
					sb.append("-");
			}
			
            if (i < N) sb.append(" ");

		}

		System.out.println(sb.toString());
		br.close();
	}

}
