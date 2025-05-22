import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t=1; t<=TC; t++) {
			boolean[][] map = new boolean[8][8];
			boolean ret = true;
			int cnt = 0;
			for (int i=0; i<8; i++) {
				String input = br.readLine();
				int w = 0; 
				for (int j=0; j<8; j++) {
					if (input.charAt(j) == 'O') { 
						map[i][j] = true;
						w++;
						cnt++;
					}
				}
				if(w>1) 
					ret = false;
			}
			
			
			if(ret) {
				for(int i=0; i<8; i++) {
					int h = 0;
					for(int j=0; j<8; j++) {
						if(map[j][i])
							h++;
					}
					if(h>1) {
						ret=false;
						break;
					}
				}
			}


			System.out.printf("#%d %s\n", t, ret&&cnt==8 ? "yes" : "no");
		}
		br.close();
	}
}




