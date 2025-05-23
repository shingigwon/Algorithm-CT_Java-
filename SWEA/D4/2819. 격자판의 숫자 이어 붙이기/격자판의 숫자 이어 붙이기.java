import java.io.*;
import java.util.*;
public class Solution {
	static class Node{
		int y;
		int x;
		int cnt;
		String nums;
		
		Node(int y, int x, int cnt, String nums){
			this.y = y;
			this.x = x; 
			this.cnt =cnt;
			this.nums = nums;
		}
	}
	
	static Set<String> set;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=TC; t++) {
			int[][] map = new int[4][4];
			set = new HashSet<String>();
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<4; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					bfs(i,j,map);
				}
			}
			
			System.out.printf("#%d %d\n", t, set.size());
		}
		br.close();
	}
	static void bfs(int y, int x, int[][] map) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(y,x,1,String.valueOf(map[y][x])));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cy = cur.y;
			int cx = cur.x;
			int cnt = cur.cnt;
			String nums = cur.nums;
			
			if(cnt==7) {
				set.add(nums);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int ny = cy+dy[i];
				int nx = cx+dx[i];
				
				if(ny<0 || ny>=4 || nx<0 || nx>=4)
					continue;
				
				q.add(new Node(ny,nx,cnt+1,nums+map[ny][nx]));
			}
		}
	}
}