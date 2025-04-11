import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
		int[] answer = new int[len];
		
		for(int i=0; i<len; i++) {
			int start = commands[i][0]-1;
			int end = commands[i][1];
			int k = commands[i][2]-1;
			List<Integer> list = new ArrayList<Integer>();
			
			for(int j = start; j<end; j++) {
				list.add(array[j]);
			}
			
			Collections.sort(list);
			answer[i] = list.get(k);
		}
		return answer;
    }
}