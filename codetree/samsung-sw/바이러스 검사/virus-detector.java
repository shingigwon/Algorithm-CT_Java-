import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rest = Integer.parseInt(br.readLine());
        int[] cust = new int[rest];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<rest; i++){
            cust[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int ldr = Integer.parseInt(st.nextToken());
        int mbr = Integer.parseInt(st.nextToken());


        long max = 0;

        for(int i=0; i<rest; i++){
            int c = cust[i]-ldr;

            // 팀장
            if(c<=0) max += 1;
            else{
                //팀원
                if(c-mbr<=0) max += 2;
                //팀원 나머지
                else max += (c%mbr!=0?1:0) + c/mbr + 1;
            }
        }

        System.out.println(max);
    }
}