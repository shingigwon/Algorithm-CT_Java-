import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int[] arr = new int[10];
		
		for(int i=0; i<N.length(); i++) {
			int num = N.charAt(i)-'0';
			
			if(num==9)
				arr[6]++;
			
			else
				arr[num]++;
		}
		arr[6] = Math.round(arr[6]/2f);
		System.out.println(Arrays.stream(arr).max().getAsInt());
		br.close();
	}
}

