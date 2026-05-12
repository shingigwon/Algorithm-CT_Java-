import java.util.*;

class Solution {
    Map<String, List<String>> map;
    boolean[] used;
    String[] answer;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        used = new boolean[tickets.length];
        answer = new String[tickets.length+1];

        for(String[] ticket : tickets){
            String key = ticket[0];
            String value = ticket[1];

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        for(List<String> value : map.values()){
            Collections.sort(value);
        }

        answer[0] = "ICN";
        dfs("ICN", 0, tickets);

        return answer;
    }
    boolean dfs(String cur, int depth, String[][] tickets){
        if(depth == tickets.length) return true;

        List<String> nextList = map.get(cur);

        if(nextList == null || nextList.isEmpty()) return false;

        for(String next : nextList){
            for(int i=0; i<tickets.length; i++){
                if(used[i]) continue;

                if(!tickets[i][0].equals(cur)) continue;
                if(!tickets[i][1].equals(next)) continue;

                used[i] = true;
                answer[depth+1] = next;

                if(dfs(next, depth+1, tickets)) return true;

                used[i] = false;
            }
        }

        return false;
    }
}