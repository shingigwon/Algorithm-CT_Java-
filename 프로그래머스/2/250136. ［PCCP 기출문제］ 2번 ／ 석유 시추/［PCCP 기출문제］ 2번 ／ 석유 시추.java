import java.util.*;

class Solution {
    static int N,M;
	static boolean[][] vis;
	static int[] sumCol;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public int solution(int[][] land) {
        int answer = 0;

		N = land.length; // 5
		M = land[0].length; // 8

		vis = new boolean[N][M];
		sumCol = new int[M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (land[i][j] == 1 && !vis[i][j]) 
					BFS(land, i, j);
			}
		}
		
		for(int sum:sumCol) 
			answer = Math.max(answer, sum);
		

		return answer;
	}
	public void BFS(int[][] land, int y, int x) {
		int sum = 0;
		Set<Integer> cols = new HashSet<Integer>();
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {y,x});
		vis[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			sum++;
			cols.add(cur[1]);
			
			for(int d=0; d<4; d++) {
				int ny = cur[0]+dy[d];
				int nx = cur[1]+dx[d];

				if(ny>=0 && ny<N && nx>=0 && nx<M && land[ny][nx]==1 && !vis[ny][nx]) {
					q.add(new int[] {ny,nx});
					vis[ny][nx] = true;
					
				}
					
			}
		}
		
		for (int col : cols) 
			sumCol[col] += sum;
	}
}