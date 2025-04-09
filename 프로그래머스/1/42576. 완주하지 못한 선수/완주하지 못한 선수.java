import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
      Map<String,Integer> map = new HashMap<String, Integer>();
		
		for(String s : completion) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
				
		for(String s : participant) {
			if(!map.containsKey(s)) 
				return s;
			
			if(map.getOrDefault(s, 0)-1==0)
				map.remove(s);
			
			else {
				map.put(s, map.getOrDefault(s, 0)-1);	
			}
		}
		
		return  map.keySet().iterator().next();
    }
}