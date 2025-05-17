import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			List<String> list = new ArrayList<String>();
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) 
				list.add(st.nextToken());
			
			int K = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				String cmd = st.nextToken();
				if(cmd.equals("I")) {
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for(int j=X; j<X+Y; j++) 
						list.add(j,st.nextToken());
				}
				else if(cmd.equals("D")) {
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for(int j=X; j<X+Y; j++) 
						list.remove(j);
				}
				else if(cmd.equals("A")) {
					int X = Integer.parseInt(st.nextToken());
					for(int j=0; j<X; j++)
						list.add(st.nextToken());
				}
				
				
			}
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<10; i++)
				sb.append(list.get(i)).append(" ");
			
			System.out.printf("#%d %s\n", t,sb.toString());
		}
		br.close();
	}
	
}
