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
            System.out.println(1);
            return;
        }
        int[] visited = new int[100001];
        int[] count = new int[100001];

        Arrays.fill(visited, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = 0;
        count[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            int[] d = {cur+1, cur-1, cur*2};

            for(int next : d){
                if(next < 0 || next > 100000)
                    continue;

                if(visited[next] != -1){
                    if(visited[next] == visited[cur]+1)
                        count[next] += count[cur];
                    continue;
                }

                visited[next] = visited[cur] + 1;
                count[next] = count[cur];
                q.add(next);
            }
        }

        System.out.println(visited[K]);
        System.out.println(count[K]);

        br.close();
    }
}
