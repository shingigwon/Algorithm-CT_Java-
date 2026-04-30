class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;

        long sum = sequence[left];

        int min = Integer.MAX_VALUE;

        while(right<sequence.length){
            if(sum == k){
                int minIdx = right - left;

                if(minIdx<min){
                    min = minIdx;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            if(sum>=k){
                sum-=sequence[left++];
            }
            else{
                right++;

                if(right<sequence.length){
                    sum+=sequence[right];
                }
            }
        }
        return answer;
    }
}