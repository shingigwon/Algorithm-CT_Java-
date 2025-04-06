import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		int[][] map = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				int t = Integer.parseInt(st.nextToken());
				map[i][j] = t;
				
				if(t==1)
					q.add(new int[] {i,j});
				
				
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=0 && ny<N && nx>=0 && nx<M && map[ny][nx]==0) {
					q.add(new int[] {ny,nx});
					map[ny][nx] = map[y][x]+1;
				}
			}
		}
		boolean check = Arrays.stream(map)
			    .flatMapToInt(Arrays::stream)
			    .anyMatch(v->v==0);
		
		int max = check?-1:Arrays.stream(map)
				.flatMapToInt(Arrays::stream)
				.max()
				.getAsInt()-1;
		
		System.out.println(max);
		br.close();
	}
	
}
