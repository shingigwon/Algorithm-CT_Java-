class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        for(char ch : s.toCharArray()){
            
            if(ch==' ')
                start = -1;
            
            if(start%2==0)
                sb.append(Character.toUpperCase(ch));
        
            else
                sb.append(Character.toLowerCase(ch));
            
            
            start++;
        }
        return sb.toString();
    }
}