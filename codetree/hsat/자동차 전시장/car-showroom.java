import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] edges = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int[] startPoints = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            startPoints[i] = Integer.parseInt(st.nextToken());
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, -1);

        for(int i=0; i<k; i++){
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int[] dist = new int[n+1];
            Arrays.fill(dist,-1);

            dist[startPoints[i]] = 0;
            q.add(new int[] {startPoints[i],0});

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int v = cur[0];
                int cnt = cur[1];

                for(int next : edges[v]){
                    if(dist[next] != -1) continue;
                    dist[next] = cnt+1;
                    q.add(new int[] {next,cnt+1});
                }
            }

            for(int j=1; j<=n; j++){
                if(dist[j]==-1)  minTime[j]=Integer.MAX_VALUE;

                else
                    minTime[j] = Math.max(dist[j], minTime[j]);
            }
        }

        System.out.println(Arrays.stream(minTime).filter(res -> res>=0&&res!=Integer.MAX_VALUE).min().orElse(-1));
    }
}