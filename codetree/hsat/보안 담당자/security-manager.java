import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        if(N%2!=0){
            System.out.println("No");
            return;
        }

        int min = 0;
        int max = 0;

        for(char ch : input.toCharArray()){
            if(ch=='('){
                max++;
                min++;
            }

            else if(ch==')'){
                min--;
                max--;
            }

            else{
                min--;
                max++;
            }

            if(min<0) min = 0;

            if(max<0) break;

        }

        System.out.println(min==0 && max>=0? "Yes" : "No");
    }
}