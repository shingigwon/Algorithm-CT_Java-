import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] score = {0,3,2,1,0,1,2,3};
        Map<Character, Integer> res = new HashMap<>();

        for(int i=0; i<survey.length; i++){
            int idx = choices[i]<4?0:1;
            char ch = survey[i].charAt(idx);
            res.merge(ch, score[choices[i]], Integer::sum);
        }
        
        StringBuilder sb = new StringBuilder();
        sb
                .append(res.getOrDefault('R',0)>=res.getOrDefault('T',0)?"R":"T")
                .append(res.getOrDefault('C',0)>=res.getOrDefault('F',0)?"C":"F")
                .append(res.getOrDefault('J',0)>=res.getOrDefault('M',0)?"J":"M")
                .append(res.getOrDefault('A',0)>=res.getOrDefault('N',0)?"A":"N");

        return sb.toString();
    }
}