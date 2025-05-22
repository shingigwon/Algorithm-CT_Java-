import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			String[] A = st.nextToken().split("");
			String[] B = st.nextToken().split("");
			
			boolean lenChk = true;
			boolean chk = true;
			if(A.length!=B.length) {
				lenChk = false;
				chk = false;
			}
			
			if(lenChk) {
				for(int i=0; i<A.length; i++) {
					if((zero.contains(A[i])&&zero.contains(B[i]))||
							(one.contains(A[i])&&one.contains(B[i]))||
							(A[i].equals("B") && B[i].equals("B"))
						)
						continue;
					else
						chk = false;
				}
			}
			
			System.out.printf("#%d %s\n",t, chk?"SAME":"DIFF");
		}
		br.close();
	}
	
}