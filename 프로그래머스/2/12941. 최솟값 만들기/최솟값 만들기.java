import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int s = 0;
        int e = A.length-1;
        while(e>-1){
            answer += A[s]*B[e];
            s++;
            e--;
        }

        return answer;
    }
}