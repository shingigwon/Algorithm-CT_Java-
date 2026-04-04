import java.util.*;

class Solution {
    ArrayList<Integer>[] arr;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        arr = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && i!=j){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }

        int answer = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }

        return answer;
    }
    public void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next : arr[cur]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }

            }
        }
    }
}