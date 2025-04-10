class Solution {
    public int[] solution(String s) {
        //0의 제거된 개수
        //제거된 s의 길이 2진수 변환 -> 1이 될 때 까지
               int[] answer = new int[2];
        
        int len = s.length();
        int zero = 0;
        int cnt = 0;
        
        while(len!=1){
            StringBuilder sb = new StringBuilder();
            
            for(char ch:s.toCharArray()){
                if(ch=='1')
                    sb.append(ch);
                else
                    zero++;
            }
            len = sb.length();
            s = new String(Integer.toBinaryString(len));
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}
