import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int res = N;
		int cnt = 0;
		
		do {
			int l = res/10;
			int r = res%10;
			int sum = l+r<10?l+r:(l+r)%10;
			
			res = r*10+sum;
			
			cnt++;
		}while(res!=N);
		
		System.out.println(cnt);
	}
}
