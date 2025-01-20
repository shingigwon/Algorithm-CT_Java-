import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numArr = br.readLine().split("");

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += Integer.parseInt(numArr[i]);
        }
        System.out.println(sum);

        br.close();
    }
}
