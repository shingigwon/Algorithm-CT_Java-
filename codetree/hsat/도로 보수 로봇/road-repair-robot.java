import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] positions = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = positions[N-1]- positions[0] +1;
        int res = right;

        while(left<=right){
            //최소값
            int mid = (left+right)/2;

            int idx = 0;
            int cnt = 0;

            while(idx<N){
                int end = positions[idx]+mid-1;
                cnt++;

                while(idx<N && positions[idx]<=end)
                    idx++;

            }

            if(cnt<=K){
                res = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        System.out.println(res);
    }
}