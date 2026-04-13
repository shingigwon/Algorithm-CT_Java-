import java.util.*;

public class DP {

    // ===================== Top-down (메모이제이션) =====================

    static int[] memo;

    static int topDown(int n) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n]; // 이미 계산했으면 바로 반환

        return memo[n] = topDown(n - 1) + topDown(n - 2);
    }
    // 사용 전 반드시 초기화
    // memo = new int[N + 1];
    // Arrays.fill(memo, -1);

    // ===================== Bottom-up (타뷸레이션) =====================
 
    static int bottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
 
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2]; // 작은 문제부터 순서대로 채움
 
        return dp[n];
    }

    // ===================== 1D DP =====================

    // 계단 오르기 - dp[i] = i번째 계단까지 최대합
    static int stairDP(int[] stair) {
        int N = stair.length;
        int[] dp = new int[N];
        dp[0] = stair[0];
        dp[1] = stair[0] + stair[1];
        dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < N; i++)
            dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);

        return dp[N - 1];
    }

    // ===================== 2D DP =====================

    // 최소 비용 경로 - dp[i][j] = (0,0)에서 (i,j)까지 최소 비용
    static int minPath(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] dp = new int[N][M];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int j = 1; j < M; j++) dp[0][j] = dp[0][j-1] + grid[0][j];

        for (int i = 1; i < N; i++)
            for (int j = 1; j < M; j++)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];

        return dp[N-1][M-1];
    }

    // ===================== 배낭 문제 =====================

    // 0/1 배낭 - 각 아이템 1번만 사용
    static int knapsack01(int[] weights, int[] values, int capacity) {
        int N = weights.length;
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i-1][w]; // 안 담는 경우
                if (w >= weights[i-1])  // 담는 경우
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w - weights[i-1]] + values[i-1]);
            }
        }
        return dp[N][capacity];
    }

    // 완전 배낭 - 각 아이템 무제한 사용 (1D 배열로 최적화)
    static int knapsackUnbounded(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];

        for (int w = 1; w <= capacity; w++)
            for (int i = 0; i < weights.length; i++)
                if (w >= weights[i])
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);

        return dp[capacity];
    }

    // ===================== LIS =====================

    // O(N²)
    static int lisN2(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // O(N log N) - 이분탐색 활용
    static int lisNlogN(int[] arr) {
        List<Integer> lis = new ArrayList<>();

        for (int val : arr) {
            int pos = Collections.binarySearch(lis, val);
            if (pos < 0) pos = -(pos + 1);

            if (pos == lis.size()) lis.add(val);
            else lis.set(pos, val); // 길이만 유효, 실제 수열 아님
        }
        return lis.size();
    }

    // ===================== LCS =====================

    static int lcs(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[N][M];
    }

    // ===================== 구간 DP =====================

    // 행렬 연쇄 곱셈 - dp[i][j] = i~j 행렬 곱셈 최소 연산 수
    static int matrixChain(int[] dims) {
        int N = dims.length - 1;
        int[][] dp = new int[N][N];

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + dims[i] * dims[k+1] * dims[j+1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][N-1];
    }

    // ===================== 비트마스크 DP =====================

    // TSP - dp[visited][cur] = visited 상태에서 cur에 있을 때 최소 비용
    static int tsp(int[][] dist) {
        int N = dist.length;
        int FULL = (1 << N) - 1;
        int[][] dp = new int[1 << N][N];
        final int INF = Integer.MAX_VALUE / 2;

        for (int[] row : dp) Arrays.fill(row, INF);
        dp[1][0] = 0;

        for (int visited = 1; visited <= FULL; visited++) {
            for (int cur = 0; cur < N; cur++) {
                if (dp[visited][cur] == INF) continue;
                if ((visited & (1 << cur)) == 0) continue;

                for (int next = 0; next < N; next++) {
                    if ((visited & (1 << next)) != 0) continue;
                    int nv = visited | (1 << next);
                    dp[nv][next] = Math.min(dp[nv][next], dp[visited][cur] + dist[cur][next]);
                }
            }
        }

        int result = INF;
        for (int cur = 1; cur < N; cur++)
            result = Math.min(result, dp[FULL][cur] + dist[cur][0]);
        return result;
    }

    // ===================== 플로이드-워셜 =====================

    // 모든 정점 쌍의 최단 거리 - O(V³), 음수 간선 가능
    static int[][] floyd(int N, int[][] edges) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[N + 1][N + 1];

        for (int[] row : dp) Arrays.fill(row, INF);
        for (int i = 1; i <= N; i++) dp[i][i] = 0;
        for (int[] e : edges) dp[e[0]][e[1]] = e[2]; // {u, v, cost}

        for (int k = 1; k <= N; k++)           // 경유지
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dp[i][k] != INF && dp[k][j] != INF)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);

        return dp;
    }

    // ===================== Tree DP =====================

    // dp[node][0] = node 선택 안 함, dp[node][1] = node 선택
    static int[][] dpTree;
    static List<Integer>[] tree;
    static int[] value;

    static void treeDP(int node, int parent) {
        dpTree[node][1] = value[node];

        for (int child : tree[node]) {
            if (child == parent) continue;
            treeDP(child, node);

            dpTree[node][0] += Math.max(dpTree[child][0], dpTree[child][1]); // node 미선택 → child 자유
            dpTree[node][1] += dpTree[child][0];                             // node 선택 → child 미선택
        }
    }
}

    // ===================== 문자열 편집 거리 =====================

    // 삽입 / 삭제 / 교체로 s1 → s2 변환하는 최소 연산 수
    static int editDistance(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) dp[i][0] = i; // s2가 빈 문자열 → 전부 삭제
        for (int j = 0; j <= M; j++) dp[0][j] = j; // s1이 빈 문자열 → 전부 삽입

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]; // 같으면 연산 불필요
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],           // 교체
                               Math.min(dp[i-1][j], dp[i][j-1])) + 1; // 삭제, 삽입
            }
        }
        return dp[N][M];
    }
