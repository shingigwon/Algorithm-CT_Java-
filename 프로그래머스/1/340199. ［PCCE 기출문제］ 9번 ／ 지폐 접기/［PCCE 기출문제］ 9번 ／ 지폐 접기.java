class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int h = bill[0];
        int w = bill[1];
        
        int mh = wallet[0];
        int mw = wallet[1];
        
        while(true){  
            if((mh>=h&&mw>=w) || mh>=w&&mw>=h)
                return answer;
            
            if(w<h)
                h/=2;
            else
                w/=2;
         
            answer++;
        }
    }
}

