class Solution {
    int[] percent = {10,20,30,40};
    int len, maxPlus, maxPrice;
    int[] selected;

    public int[] solution(int[][] users, int[] emoticons) {
        len = emoticons.length;
        selected = new int[len];
        maxPlus = 0;
        maxPrice = 0;

        perm(0, users,emoticons);
        return new int[]{maxPlus,maxPrice};
    }
    public void perm(int depth, int[][] users, int[] emoticons){
        if(depth == len){
            int plus = 0;
            int price = 0;

            for(int[] user : users){
                int total = 0;

                for(int i=0; i<selected.length; i++){
                    if(selected[i]>= user[0])
                        total+=emoticons[i] * (100-selected[i])/100;
                }
                if(total>= user[1]) plus++;
                else price+= total;
            }
            if(plus > maxPlus){
                maxPlus = plus;
                maxPrice = price;
            } else if(plus == maxPlus && price > maxPrice){
                maxPrice = price;
            }
            return;
        }

        for(int i=0; i<4; i++){
            selected[depth] = percent[i];
            perm(depth+1, users, emoticons);
        }
    }
}
