import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] right = new int[n+1];
        int[] freq = new int[n+1];

        for(int k=2; k<n; k++){
            right[arr[k]]++;
        }
        
        int res = 0;

        for(int j=1; j<n-1; j++){

            //빈도수 체크
            freq[0] = 0;
            for(int v=1; v<=n; v++){
                freq[v] = freq[v-1] + right[v];
            }

            //값 비교
            for(int i=0; i<j; i++){
                if(arr[i]>=arr[j]) continue;

                res+=freq[arr[i]-1];
            }

            // 다음 기준값 뺴기
            right[arr[j+1]]--;
        }

        System.out.println(res);
    }
}

// i < j < k         -> idx
// ai < aj / ai > ak -> value
