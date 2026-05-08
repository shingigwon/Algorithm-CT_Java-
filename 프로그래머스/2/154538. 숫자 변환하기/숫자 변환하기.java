import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x,y,n);
    }

    int bfs(int x, int y, int n){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] vis = new boolean[y+1];

        q.add(new int[] {x,0});
        vis[x] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int target = cur[0];
            int cnt = cur[1];

            if(target == y){
                return cnt;
            }

            if(target > y)continue;
            int[] next = {target+n, target*2, target*3};
            for(int i : next){
                if(i<=y && !vis[i]){
                    q.add(new int[] {i, cnt+1});
                    vis[i] = true;
                }
            }
        }

        return -1;
    }
}