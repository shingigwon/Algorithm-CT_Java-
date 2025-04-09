import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i:arr){
            if(!stack.isEmpty()&&stack.peek()==i)
                continue;
            
            stack.add(i);
            list.add(i);
        }
    	return list.stream().mapToInt(v->v).toArray();
    }
}