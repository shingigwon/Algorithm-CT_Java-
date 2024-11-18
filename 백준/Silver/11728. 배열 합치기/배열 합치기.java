import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for(int a=0; a<N; a++) {
			arr[a]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int b=N; b<N+M; b++) {
			arr[b]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(arr[i]);
            if (i != N + M - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
			
		
	}

}
