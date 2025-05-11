import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] vis = new boolean[100001];
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {N,0});
		vis[N] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int X = cur[0];
			int dist = cur[1];
			
			if(X==K) {
				System.out.println(dist);
				break;
			}
			int[] nums = {X-1, X+1, X*2};
			
			for(int next:nums)
				if(next>=0 && next<=100000 && !vis[next]) {
					q.add(new int[] {next,dist+1});
					vis[next] = true;
				}
			
		}
		br.close();
	}
}
