class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (true) {
            int k = n / a;
			n = n - k * a + k * b;
			answer += k*b;

			if (n < a)
				return answer;
		}
    }
}