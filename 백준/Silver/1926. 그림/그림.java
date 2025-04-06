import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static List<int[]> pos;
	static int cnt=0;
	static int res=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		pos = new ArrayList<int[]>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				pos.add(new int[] {i,j});
			}
		}
		for(int[] cur:pos) {
			res = Math.max(res, BFS(cur));
		}
		System.out.println(cnt);
		System.out.println(res);
		br.close();
	}
	
	static int BFS(int[] cur) {
		Queue<int[]> q = new LinkedList<int[]>();
		int py = cur[0];
		int px = cur[1];
		if(map[py][px]==0)
			return 0;
		
		q.add(cur);
		map[py][px] = 0;
		cnt++;
		int res = 1;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=0 && ny<N && nx>=0 &&nx<M && map[ny][nx]==1) {
					q.add(new int[] {ny,nx});
					map[ny][nx] = 0;
					res++;
				}
			}
		}
		
		return res;
	}
}
