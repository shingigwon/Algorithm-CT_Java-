import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] used;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        used = new boolean[numbers.length()];

        perm("", numbers);

        int cnt = 0;

        for(int i : set){
            if(i<2) continue;
            boolean isPrime = true;
            
            for(int j=2; j*j<=i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                cnt++;
        }
        return cnt;
    }

    void perm(String cur, String numbers){
        if(!cur.isEmpty())
            set.add(Integer.parseInt(cur));

        for(int i=0; i<numbers.length(); i++){
            if(used[i]) continue;

            used[i] = true;
            perm(cur+numbers.charAt(i), numbers);

            used[i] = false;
        }
    }
}