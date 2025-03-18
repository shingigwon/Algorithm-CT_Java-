import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())-1;
		
		int res = 1;
		int i = 6;
		int j = 1;
		while(N>0) {
			N -=(i*j++);
			res++;
		}
		
		System.out.println(res);
		br.close();
	}
	
}