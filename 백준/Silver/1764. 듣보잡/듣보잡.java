import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> strSet = new HashSet<>();
		String[] strArr; 
		int count = 0;
		for (int i = 0; i < N + M; i++) {
			String line = br.readLine();
			
			if(strSet.contains(line)) {
				sb.append(line+" ");
				count++;
			}
			strSet.add(line);
		}
		st = new StringTokenizer(sb.toString());
		strArr = new String[count];
		
		for(int i=0; i<count; i++) {
			strArr[i]=st.nextToken();
		}
		Arrays.sort(strArr);
		System.out.println(count);
		for(String str:strArr) {
			System.out.println(str);
		}
		br.close();
		
	}

}


