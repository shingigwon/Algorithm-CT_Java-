import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,-1,1};

		char[][] map = new char[R][C];
		int[][] J_vis = new int[R][C];
		int[][] F_vis = new int[R][C];
		
		Queue<int[]> jq = new LinkedList<int[]>();
		Queue<int[]> fq = new LinkedList<int[]>();
		
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			Arrays.fill(J_vis[r], -1);
			Arrays.fill(F_vis[r], -1);
			
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				
				if(map[r][c]=='J') {
					J_vis[r][c] = 0;
					jq.add(new int[] {r,c});
				}
				
				else if(map[r][c]=='F') {
					F_vis[r][c] = 0;
					fq.add(new int[] {r,c});
				}
			}
		}
		
		
		while(!fq.isEmpty()) {
			int[] cur = fq.poll();
			int y = cur[0];
			int x = cur[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if (map[ny][nx] == '#' || F_vis[ny][nx] != -1) continue;

				F_vis[ny][nx] = F_vis[cur[0]][cur[1]] + 1;
				fq.add(new int[]{ny, nx});
			}
		}
		
		while(!jq.isEmpty()) {
			int[] cur = jq.poll();
			int y = cur[0];
			int x = cur[1];
			
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];

				if(ny<0||ny>=R||nx<0||nx>=C) {
					System.out.println(J_vis[y][x]+1);
					return;
				}
				
				if (map[ny][nx] == '#' || J_vis[ny][nx] != -1) continue;
				if (F_vis[ny][nx] != -1 && F_vis[ny][nx] <= J_vis[y][x] + 1) continue;


				J_vis[ny][nx] = J_vis[y][x] + 1;
				jq.add(new int[]{ny, nx});
			}
		}
		
		System.out.println("IMPOSSIBLE");
		br.close();
	}
	
}
