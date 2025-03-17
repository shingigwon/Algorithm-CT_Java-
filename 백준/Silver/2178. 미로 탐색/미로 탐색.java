import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] vis = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			Arrays.fill(vis[i], false);
			for(int j=0; j<M; j++) {
				int n = Integer.parseInt(input[j]);
				map[i][j] = n;
				if(n==0)
					vis[i][j] = true;
			}
		}
		System.out.println(Func(map, vis, N, M));
		br.close();
	}
	
	static int Func(int[][] map, boolean[][] vis, int N, int M) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2)-> Integer.compare(o1[2], o2[2]));
		pq.add(new int[]{0,0,1});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cy = cur[0];
			int cx = cur[1];
			int cost = cur[2];
			
			if(cy == N-1 && cx == M-1)
				return cost;
			
			
			for(int i=0; i<4; i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				
				if(ny<N && ny>=0 && nx>=0 && nx<M && !vis[ny][nx]) {
					pq.add(new int[] {ny,nx, cost+1});
					vis[ny][nx] = true;
				}
			}
		}
		
		return -1;
	}

}

