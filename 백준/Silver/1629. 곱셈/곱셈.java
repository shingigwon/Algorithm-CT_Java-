import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(recur(A, B, C));
		br.close();
	}
	
	static long recur(int a, int b, int c) {
		if(b==1) return a%c;
		
		long v = recur(a, b/2, c);
		v=v*v%c;
		
		if(b%2==0) return v;
		return v*a%c;
	}
}
