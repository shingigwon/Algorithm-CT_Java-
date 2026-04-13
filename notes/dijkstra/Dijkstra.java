import java.util.*;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE / 2;

    // graph[i] = {nextNode, cost} 리스트
    static int[] dijkstra(int start, int V, List<int[]>[] graph) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // {거리, 노드} 최소힙
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], node = cur[1];

            // 오래된 정보면 skip
            if (dist[node] < cost) continue;

            for (int[] next : graph[node]) {
                int nextNode = next[0], nextCost = next[1];

                if (dist[node] + nextCost < dist[nextNode]) {
                    dist[nextNode] = dist[node] + nextCost;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        return dist; // dist[i] = start -> i 최단 거리, INF면 도달 불가
    }

    // 그래프 초기화 예시
    // List<int[]>[] graph = new ArrayList[V + 1];
    // for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

    // 단방향 (Directed): u → v 만
    // graph[u].add(new int[]{v, cost});

    // 양방향 (Undirected): u ↔ v 둘 다
    // graph[u].add(new int[]{v, cost});
    // graph[v].add(new int[]{u, cost});
}
