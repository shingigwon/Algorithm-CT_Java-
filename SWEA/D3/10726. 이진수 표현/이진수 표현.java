import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String binary = Integer.toBinaryString(M);
			boolean chk = true;
			
			if(binary.length()<N) 
				chk=false;
			
			else {
				String ret = binary.substring(binary.length()-N);
				if(ret.contains("0"))
					chk = false;
			}
						
			System.out.printf("#%d %s\n",t, chk?"ON":"OFF");
		}
		br.close();
	}
}



