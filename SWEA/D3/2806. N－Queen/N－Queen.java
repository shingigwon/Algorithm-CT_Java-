import java.io.*;

public class Solution {
	static int N,ret;
	static boolean[] colVis, rdVis, ldVis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			ret = 0;
			colVis = new boolean[N];
			rdVis = new boolean[2*N-1];
			ldVis = new boolean[2*N-1];
			
			comb(0);
			System.out.printf("#%d %d\n",t,ret);
		}
		br.close();
	}
	
	static void comb(int row) {
		if(row==N) {
			ret++;
			return;
		}
		
		for(int col=0; col<N; col++) {
			if(colVis[col]||rdVis[row+col]||ldVis[row-col+N-1])
				continue;
			
			colVis[col] = true;
			rdVis[row+col]=true;
			ldVis[row-col+N-1] = true;
			
			comb(row+1);
			
			colVis[col] = false;
			rdVis[row+col]=false;
			ldVis[row-col+N-1] = false;
			
		}
		
		
	}
}	
