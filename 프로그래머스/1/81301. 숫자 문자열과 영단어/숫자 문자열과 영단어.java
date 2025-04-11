class Solution {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", 
                      "eight", "nine"};
        
        for(int i=0; i<num.length; i++){
            switch(num[i]){
                    case "zero":
                     s = s.replace("zero", "0");
                    break;
                case "one":
                    s = s.replace("one", "1");
                    break;
                case "two":
                    s = s.replace("two", "2");
                    break;
                case "three":
                    s = s.replace("three", "3");
                    break;
                case "four":
                    s = s.replace("four", "4");
                    break;
                case "five":
                    s = s.replace("five", "5");
                    break;
                case "six":
                    s = s.replace("six", "6");
                    break;
                case "seven":
                    s = s.replace("seven", "7");
                    break;
                case "eight":
                    s = s.replace("eight", "8");
                    break;
                case "nine":
                    s = s.replace("nine", "9");
                    break;
            }
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}