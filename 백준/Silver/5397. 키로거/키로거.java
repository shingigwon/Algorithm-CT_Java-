import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			LinkedList<Character> list = new LinkedList<Character>();
			ListIterator<Character> iter = list.listIterator();
			
			for(char ch :input.toCharArray()) {
				if(ch=='<') {
					if(iter.hasPrevious())	iter.previous();
				}
				else if(ch=='>') {
					if(iter.hasNext())	iter.next();
				}
				else if(ch=='-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
				else {
					iter.add(ch);
				}
			}
			for(char ch:list) 
				sb.append(ch);
			
			System.out.println(sb);
		}
		br.close();
	}
}
