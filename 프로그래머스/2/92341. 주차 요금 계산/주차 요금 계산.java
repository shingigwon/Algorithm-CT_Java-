import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> time = new HashMap<>();
        Map<String, Integer> fee = new TreeMap<>();

        for(String str : records){
            String[] input = str.split(" ");

            if(input[2].equals("OUT")){
                if(time.containsKey(input[1])){
                    String[] start = time.get(input[1]).split(":");
                    String[] end = input[0].split(":");

                    int s = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
                    int e = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);

                    fee.merge(input[1], e-s, Integer::sum);
                    time.remove(input[1]);
                }
            }

            else
                time.put(input[1], input[0]);
        }

        for(String key : time.keySet()){
            String[] start = time.get(key).split(":");
            int min = 23*60+59 - (Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]));
            fee.merge(key, min, Integer::sum);
        }

        int[] answer = new int[fee.size()];

        int idx = 0;
        for(String key : fee.keySet()){

            int total = fee.get(key);
            if(total<=fees[0])
                answer[idx] = fees[1];

            else
                answer[idx] = fees[1] + (int)Math.ceil((double)(total-fees[0]) / fees[2]) * fees[3];

            System.out.println(answer[idx]);
            idx++;
        }

        return answer;
    }
}