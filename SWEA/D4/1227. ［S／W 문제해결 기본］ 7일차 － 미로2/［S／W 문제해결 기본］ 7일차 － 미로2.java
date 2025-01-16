import java.io.*;
import java.util.*;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			visited = new boolean[100][100];
			
			int startx = -1;
			int starty = -1;
			
			for(int i=0; i<100; i++) {
				String[] str = br.readLine().split("");
				for(int j=0; j<100; j++) {
					int num = Integer.parseInt(str[j]);
					arr[i][j] = num;
					if(num==2) {
						startx = i;
						starty = j;
					}
				}
			}
			boolean check =DFS(startx, starty); 
			System.out.printf("#%d %d\n",T, check?1:0);
		}
		
		br.close();
	}
	
	static boolean DFS(int x, int y) {
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(new int[] {x,y});
		visited[x][y] = true;
		
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			int cx = cur[0];
			int cy = cur[1];
			
			
			for(int i=0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(arr[nx][ny]==3)
					return true;
				
				if(nx>=0 && nx<100 && ny>=0 && ny<100 && arr[nx][ny]==0&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					stack.push(new int[] {nx, ny});
				}
			}
		}
		return false;
	}
}