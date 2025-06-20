import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				if(input.charAt(j)=='*')
					q.add(new int[] {i+1,j+1});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int[] head = q.poll();
		int hY = head[0]+1;
		int hX = head[1];
		sb.append(hY).append(" ").append(hX).append("\n");
		
		int la = 0;
		int ra = 0;
		int body = 0;
		int ll = 0;
		int rl = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0]==hY) {
				if(cur[1]<hX)
					la++;
				if(cur[1]>hX)
					ra++;
			}
			else if(cur[1]==hX)
				body++;
			
			else if(cur[1]<hX)
				ll++;
			
			else if(cur[1]>hX)
				rl++;
		}

		sb.append(la).append(" ")
		.append(ra).append(" ")
		.append(body).append(" ")
		.append(ll).append(" ")
		.append(rl);
		
		System.out.println(sb.toString());
		br.close();
	}
	

}