import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int T = 10;

		for (int t = 1; t < T+1; t++) {
			int count = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			
			
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				arr[i] = str.toCharArray();
			}
			
			int result = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					sb.append(arr[i][j]);
					sb2.append(arr[j][i]);
					
					if(j>=count){
						sb.deleteCharAt(0);
						sb2.deleteCharAt(0);
					}
					
					if(sb.length()==count) {
						String str = sb.toString();
						String str2 = sb2.toString();
						
						sb.reverse();
						sb2.reverse();
						
						String reverse = sb.toString();
						String reverse2 = sb2.toString();
						
						if(str.equals(reverse)) {
							result++;
						}
						if(str2.equals(reverse2)) {
							result++;
						}
						
						sb.reverse();
						sb2.reverse();
					}
				}
				sb.setLength(0);
				sb2.setLength(0);
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
		br.close();
	}

}
