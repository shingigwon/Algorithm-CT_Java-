import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i :tangerine)
			map.put(i, map.getOrDefault(i, 0)+1);
		
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		entryList.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
		
		for(Map.Entry<Integer, Integer> entry : entryList) {
			if(k<=0)
				return answer;
			k-=entry.getValue();
			answer++;
		}
        return answer;
    }
}