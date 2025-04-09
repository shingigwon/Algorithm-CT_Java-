class Solution {
 public static String solution(String s) {
    	StringBuilder answer = new StringBuilder();
        boolean isFisrt = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(ch);
                isFisrt = true;
            }
            
            else {
            	if (isFisrt) {
                    answer.append(Character.toUpperCase(ch));
                    isFisrt = false;
                } 
                else 
                    answer.append(Character.toLowerCase(ch));   
            }
        }
        return answer.toString();
    }
}