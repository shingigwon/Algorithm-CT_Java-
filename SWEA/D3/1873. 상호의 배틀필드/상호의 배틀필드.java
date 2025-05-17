import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			int curY = 0;	//2
			int curX = 0;	//1
			char curDir = ' ';
			
			for(int i=0; i<H; i++) {
				String input = br.readLine();
				for(int j=0; j<W; j++) {
					char ch = input.charAt(j);
					if(ch == '^' || ch == 'v' || ch == '<'|| ch =='>') {
						curY = i;
						curX = j;
						curDir = ch;
					}
					map[i][j] = ch; 
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String cmds = br.readLine();
			for(int i=0; i<N; i++) {
				switch(cmds.charAt(i)) {
				case 'U':
					curDir = '^';
					map[curY][curX] = curDir;
					if(curY-1>=0 && map[curY-1][curX]=='.') {
						map[curY][curX] = '.';
						curY-=1;
						map[curY][curX] = curDir;
					}
					break;
					
				case 'D':
					curDir = 'v';
					map[curY][curX] = curDir;
					if(curY+1<H && map[curY+1][curX] == '.') {
						map[curY][curX] = '.';
						curY+=1;
						map[curY][curX] = curDir;
					}
					break;
					
				case 'L':
					curDir = '<';
					map[curY][curX] = curDir;
					if(curX-1>=0 && map[curY][curX-1] == '.') {
						map[curY][curX] = '.';
						curX-=1;
						map[curY][curX] = curDir;
					}
					break;
					
				case 'R':
					curDir = '>';
					map[curY][curX] = curDir;
					if(curX+1<W && map[curY][curX+1] == '.') {
						map[curY][curX] = '.';
						curX+=1;
						map[curY][curX] = curDir;
					}
					break;
				case 'S':
					if(curDir=='^') {
						int ny = curY;
						while(ny>=0 && map[ny][curX] != '#') {
							if(map[ny][curX] == '*') {
								map[ny][curX] = '.';
								break;
							}
							ny--;
						}
					}
					else if(curDir=='v') {
						int ny = curY;
						while(ny<H && map[ny][curX] != '#') {
							if(map[ny][curX] == '*') {
								map[ny][curX] = '.';
								break;
							}
							ny++;
						}
					}
					else if(curDir=='<') {
						int nx = curX;
						while(nx>=0 && map[curY][nx] != '#') {
							if(map[curY][nx] == '*') {
								map[curY][nx] = '.';
								break;
							}
							nx--;
						}
					}
					else if(curDir=='>') {
						int nx = curX;
						while(nx<W && map[curY][nx] != '#') {
							if(map[curY][nx] == '*') {
								map[curY][nx] = '.';
								break;
							}
							nx++;
						}
					}
					break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) 
					sb.append(map[i][j]);
				sb.append("\n");
			}
			System.out.printf("#%d %s", t,sb.toString());
		}
		br.close();
	}
}
