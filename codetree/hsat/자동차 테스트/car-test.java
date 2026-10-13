import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<q; i++){
            int query = Integer.parseInt(br.readLine());
            int idx = Arrays.binarySearch(a,query);

            if(idx<0){
                sb.append(0).append("\n");
            }
            else{
                sb.append(idx * (n-(idx+1))).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}