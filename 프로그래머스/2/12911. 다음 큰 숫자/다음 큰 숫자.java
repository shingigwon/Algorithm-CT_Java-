class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int answer;

        int next = n+1;
        while(true){
            int count = Integer.bitCount(next);
            if(count==cnt){
                answer = next;
                break;
            }
            next++;
        }

        return answer;
    }
}