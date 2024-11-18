import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			int n = q.poll();
			q.offer(n);
		}
		System.out.println(q.peek());
			
	}

}
