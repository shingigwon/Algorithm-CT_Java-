import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		List<String> channel = new ArrayList<>();
        
        for (int i = 0; i < N; i++) 
        	channel.add(br.readLine());
        

        int idx1 = channel.indexOf("KBS1");
        int idx2 = channel.indexOf("KBS2");
        
        if(idx1>idx2) idx2++;
        
        for(int i=0; i<idx1; i++) sb.append("1");
        for(int i=0; i<idx1; i++) sb.append("4");
        
        
        for(int i=0; i<idx2; i++) sb.append("1");
        for(int i=1; i<idx2; i++) sb.append("4");
        
		System.out.println(sb.toString());
		br.close();
	}
	
}
