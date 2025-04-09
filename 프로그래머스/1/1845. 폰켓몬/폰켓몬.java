import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
    	int max = nums.length/2;
    	
    	for(int i:nums)
    		set.add(i);
    	
    	return Math.min(max, set.size());
    }
}