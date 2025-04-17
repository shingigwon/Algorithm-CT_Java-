import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, Integer> map = new TreeMap<String, Integer>();
        
        for(int i=0; i<strings.length; i++){
        	String str = strings[i].charAt(n)+strings[i].substring(0, n)+strings[i].substring(n+1, strings[i].length());
        	map.put(str, i);
        }
        
        int i=0;
        for(String s : map.keySet()) {
        	answer[i] = strings[map.get(s)];
        	i++;
        }
        return answer;
    }
}