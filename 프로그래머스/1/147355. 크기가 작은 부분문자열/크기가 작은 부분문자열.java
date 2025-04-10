class Solution {
    public int solution(String t, String p) {
int len = p.length();
        int answer = 0;
        
        for(int i=0; i<=t.length()-len; i++){
        	StringBuilder sb = new StringBuilder();
        	
        	for(int j=i; j<i+len; j++) {
        		sb.append(t.charAt(j));
        	}
        	
        	long n = Long.parseLong(sb.toString());
            if(n<=Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}