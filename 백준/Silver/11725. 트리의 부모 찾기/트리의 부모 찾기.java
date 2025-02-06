import java.io.*;
import java.util.*;
//BFS
public class Main {
	static ArrayList<Integer>[] arr;
	static int[] p;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		p = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[v].add(e);
			arr[e].add(v);
		}
		
		BFS(1);
		for(int i=2; i<N+1; i++) {
			System.out.println(p[i]); 
		}
		br.close();
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		queue.add(v);
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for(int next:arr[poll]) {
				if(!visited[next]) {
					visited[next]=true;
					p[next] = poll;
					queue.add(next);
				}
			}
		}
	}
	
}


/*
	       1
	     /   \
	    6     4
	   /     / \
	  3     2   7
	 /
	5

          1
        /   \
       2     3
      /     /   \
     4     5     6
    / \   / \   /  \
   7   8 9  10 11  12

 
 
 */
