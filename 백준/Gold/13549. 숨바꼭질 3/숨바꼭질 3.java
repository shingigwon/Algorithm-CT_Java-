import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N==K){
            System.out.println(0);
            return;
        }

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> visited[o1] - visited[o2]);

        q.add(N);
        visited[N] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            int[] d = {cur+1, cur-1, cur*2};

            for(int next : d){
                if(next<0 || next>100000)
                    continue;

                int cost = (next == cur*2 && next!=cur)?0:1;
                int dist = visited[cur]+cost;

                if(visited[next]>dist){
                    visited[next] = dist;
                    q.add(next);
                }
            }
        }

        System.out.println(visited[K]);
        br.close();
    }
}
