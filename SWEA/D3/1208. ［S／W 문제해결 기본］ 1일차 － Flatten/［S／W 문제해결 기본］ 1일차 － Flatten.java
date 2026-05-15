import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc<=10; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[100];
            for(int i=0; i<100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++){
                int minIdx = 0;
                int maxIdx = 0;

                for(int j=0; j<100; j++){
                    if(arr[j]>arr[maxIdx]) maxIdx = j;
                    if(arr[j]<arr[minIdx]) minIdx = j;
                }
                arr[maxIdx]--;
                arr[minIdx]++;
            }

            int max = Arrays.stream(arr).max().getAsInt();
            int min = Arrays.stream(arr).min().getAsInt();

            System.out.printf("#%d %d\n",tc, max-min);
        }
    }
}
