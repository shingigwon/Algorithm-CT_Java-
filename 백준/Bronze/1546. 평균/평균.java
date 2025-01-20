import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Max = Integer.MIN_VALUE;
		
		int sum=0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum+=num;
			
			if(num>Max)
				Max = num;
		}
		
		System.out.println(sum*100.0/Max/N);
		
		
		br.close();
		

	}

}