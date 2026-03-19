import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[26];

            String str = st.nextToken();
            char prev = str.charAt(0);
            visited[prev-'a'] = true;

            boolean chk = false;

            for(int j=1; j<str.length(); j++) {
                char cur = str.charAt(j);

                if (prev != cur && visited[cur - 'a']) {
                    chk = true;
                    break;
                }
                
                visited[cur-'a'] = true;
                prev = cur;
            }
            
            if(!chk)
                cnt ++;
        }

        System.out.println(cnt);
        br.close();
    }
}
