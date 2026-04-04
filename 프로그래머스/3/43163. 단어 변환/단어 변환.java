import java.util.*;

class Solution {
    ArrayList<Integer>[] arr;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int targetIdx = -1;

        for(int i=0; i<words.length; i++){
            if(target.equals(words[i]))
                targetIdx = i;
        }

        if(targetIdx==-1)
            return 0;

        arr = new ArrayList[words.length];
        visited = new boolean[words.length];

        for(int i=0; i<words.length; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(check(words[i], words[j])){
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<words.length; i++){
            if(check(begin, words[i])){
                q.add(new int[] {i,1});
                visited[i] = true;
            }
        }
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0];
            int count = cur[1];

            if(targetIdx==idx)
                return count;

            for(int next : arr[idx]){
                if(!visited[next]){
                    q.add(new int[] {next,count+1});
                    visited[next] = true;
                }
            }
        }
        return 0;
    }
    public boolean check(String o1, String o2){
        int chk = 0;
        for(int i=0; i<o1.length(); i++){
            if(o1.charAt(i) != o2.charAt(i)) chk++;
        }
        return chk==1;
    }
}