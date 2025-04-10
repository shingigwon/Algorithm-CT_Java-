// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 *홀수 약수의 개수*와 같다
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            if(n%i==0&&i%2!=0)
                answer++;
        }
        
        return answer;
    }
}
