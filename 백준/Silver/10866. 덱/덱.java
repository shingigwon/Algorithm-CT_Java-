import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			switch(cmd){
			case "push_front":
				q.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				q.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				sb.append(q.isEmpty()?-1:q.removeFirst()).append("\n");
				break;
			case "pop_back":
				sb.append(q.isEmpty()?-1:q.removeLast()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty()?1:0).append("\n");
				break;
			case "front":
				sb.append(q.isEmpty()?-1:q.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(q.isEmpty()?-1:q.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
