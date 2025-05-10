import java.io.*;
import java.util.*;

public class Main {
	static int R,C;
	static char[][] map;
	static boolean[][] vis;
	static List<int[]> pos;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		vis = new boolean[R][C];
		pos = new ArrayList<int[]>();
		
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				char ch = input.charAt(j);
				map[i][j] = ch;
				
				if(ch == 'v' || ch == 'o')
					pos.add(new int[] {i,j});
			}
		}
		int o = 0;
		int v = 0;
		for(int[] cur : pos) {
			int[] res = BFS(cur);
			o+=res[0];
			v+=res[1];
		}
		System.out.println(o + " " + v);
		br.close();
	}
	
	static int[] BFS(int[] cur) {
		if(vis[cur[0]][cur[1]])
			return new int[] {0,0};
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(cur);
		vis[cur[0]][cur[1]] = true;
		int v = 0;
		int o = 0;
		
		if(map[cur[0]][cur[1]]=='o')
			o++;
		else
			v++;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int y = poll[0];
			int x = poll[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny<0 || ny>=R || nx<0 || nx>=C||map[ny][nx]=='#'||vis[ny][nx])
					continue;
				
				if(map[ny][nx]=='o')
					o++;
				
				if(map[ny][nx]=='v')
					v++;
				
				q.add(new int[] {ny,nx});
				vis[ny][nx] = true;
			}
		}
		if(v<o)
			v=0;
		else
			o=0;
		
		return new int[] {o,v}; 
	}
}
