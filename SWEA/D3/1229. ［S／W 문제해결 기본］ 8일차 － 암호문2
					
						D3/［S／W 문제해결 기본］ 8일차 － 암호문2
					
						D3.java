import java.io.*;
import java.util.*;

class Solution{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		StringTokenizer st;
		for(int tc = 1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());	
			ArrayList<Integer> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int cmd = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<cmd; i++) {
				char ch = st.nextToken().charAt(0);
				if(Character.isUpperCase(ch)) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					if(ch == 'I') {
						for(int j=0; j<y; j++) {
							list.add(x+j, Integer.parseInt(st.nextToken()));
						}
					}
					else if(ch=='D'){
						for(int j=0; j<y; j++) {
							list.remove(x);
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}
