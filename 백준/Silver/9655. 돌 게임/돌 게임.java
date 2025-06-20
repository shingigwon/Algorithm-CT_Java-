import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ret = 0;
		while(N>0) {
			ret++;
			if(N>=3) 
				N-=3;
			else
				N-=1;
		}
		System.out.println(ret%2==1?"SK":"CY");
		br.close();
	}
	

}