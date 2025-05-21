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
			
			int[] R = new int[N+1];
			int[] W = new int[M+1];
			
			for(int i=1; i<=N; i++) 
				R[i]=Integer.parseInt(br.readLine());
			
			for(int i=1; i<=M; i++) 
				W[i]=Integer.parseInt(br.readLine());			
			
			int ret = 0;
			
			int[] parks = new int[N+1];
			int[] vis = new int[M+1];
			
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=0; i<M*2; i++) {
				int car = Integer.parseInt(br.readLine());
				if(car>0) {
					boolean isVis = false;
					
					for(int s=1; s<=N; s++) {
						if(parks[s] == 0) {
							parks[s] = car;
							vis[car] = s;
							ret+=R[s]*W[car];
							isVis = true;
							break;
						}
					}
					
					if(!isVis) 
						q.add(car);
				}
				else {
					int carOut = -car;
					int s = vis[carOut];
					parks[s] = 0;
					
					if(!q.isEmpty()) {
						int waitCar = q.poll();
						parks[s] = waitCar;
						vis[waitCar] = s;
						ret+=R[s]*W[waitCar];
					}
				}
			}
			
			
			System.out.printf("#%d %d\n",t, ret);
		}
		br.close();
	}
}



