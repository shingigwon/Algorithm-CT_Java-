import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			int idx = -1;
			
			if(map.get(ch)!=null) {
				idx = i-map.get(ch);
				map.put(ch, i);
			}
			else
				map.put(ch, map.getOrDefault(ch, i));
			
			answer[i] = idx;
		}
		return answer;
    }
}