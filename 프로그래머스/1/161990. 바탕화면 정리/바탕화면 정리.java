import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
         int[] answer = new int[4];
        
        List<Integer> ylist = new ArrayList<Integer>();
        List<Integer> xlist = new ArrayList<Integer>();
        
        for(int i=0; i<wallpaper.length; i++){
            int idx = 0;
            for(char ch : wallpaper[i].toCharArray()){
                if(ch=='#') {
                	ylist.add(i);
                	xlist.add(idx);
                }
                idx++;
            }
        }
        
        answer[0] = ylist.stream().min(Integer::compareTo).get();
        answer[1] = xlist.stream().min(Integer::compareTo).get();
        answer[2] = ylist.stream().max(Integer::compareTo).get()+1; 
        answer[3] = xlist.stream().max(Integer::compareTo).get()+1; 
        
        
        return answer;
    
    }
}