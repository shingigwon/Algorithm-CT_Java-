import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Map<Integer, Double> map = new HashMap<Integer, Double>();

			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				double res = a*0.35+b*0.45+c*0.2;
				map.put(i, res);
			}
			
            List<Double> score = new ArrayList<Double>(map.values());
            score.sort(Collections.reverseOrder());
            
            int grade = score.indexOf(map.get(K));
			
			System.out.printf("#%d %s\n",t, grades[grade /(N/10)]);
		}
		br.close();
	}
}
