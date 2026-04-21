class Solution {
    public int solution(int number, int limit, int power) {
    	int answer = 1;
    	for(int i=2; i<=number; i++) {
    		int res = 0;
    		for(int j=1; j*j<=i; j++) {
    			if(i%j==0){
                    res++;
                    if(j*j!=i)
                        res++;
                }
    		}
    		if(limit<res)
    			res = power;
    		
    		answer += res;
    	}
    	
    	return answer;
    }
}
