import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n + 2];
        int[] next = new int[n + 2];

        for (int i = 0; i <= n + 1; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        int cur = k + 1;
        boolean[] deleted = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st;
        for (String s : cmd) {
            st = new StringTokenizer(s);
            switch (st.nextToken()) {
                case "U" -> {
                    int x = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < x; i++)
                        cur = prev[cur];
                }
                case "D" -> {
                    int x = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < x; i++)
                        cur = next[cur];
                }
                case "C" -> {
                    deleted[cur] = true;
                    stack.push(cur);
                    next[prev[cur]] = next[cur];
                    prev[next[cur]] = prev[cur];

                    cur = (next[cur] <= n) ? next[cur] : prev[cur];
                }
                case "Z" -> {
                    int node = stack.pop();
                    deleted[node] = false;

                    next[prev[node]] = node;
                    prev[next[node]] = node;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(deleted[i] ? "X" : "O");
        }
        return sb.toString();
    }
}