import java.time.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        LocalTime len = strToTime(video_len);
        LocalTime cur = strToTime(pos);
        LocalTime start = strToTime(op_start);
        LocalTime end = strToTime(op_end);
        
        if(!cur.isBefore(start) && !cur.isAfter(end))
            cur = end;
        
        for(String cmd : commands){
            
            if(cmd.equals("next")){
                cur = cur.plusSeconds(10);
                
                if(cur.isAfter(len))
                    cur = len;
            }
            
            else{
                if(cur.getMinute()==0 && cur.getSecond()<10)
                    cur = LocalTime.of(0,0,0);
                else
                    cur = cur.minusSeconds(10);
            }
            
            if(!cur.isBefore(start) && !cur.isAfter(end))
                cur = end;
        }
        return String.format("%02d:%02d", cur.getMinute(), cur.getSecond());
        
    }
    
    private LocalTime strToTime(String str){
        return LocalTime.of(0,Integer.parseInt(str.substring(0,2)), Integer.parseInt(str.substring(3)));
    }
}