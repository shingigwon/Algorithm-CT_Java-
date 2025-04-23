import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
            int y = 0, x = 0;
            int dir = 0;
            int num = 1;

            while (num <= N*N) {
                arr[y][x] = num++;

                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || arr[ny][nx] != 0) {
                    dir = (dir + 1) % 4;

                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }

                y = ny;
                x = nx;
            }
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			
			for(int[] i: arr) {
				for(int j: i) 
					sb.append(j).append(" ");
				sb.append("\n");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
		br.close();
	}
}