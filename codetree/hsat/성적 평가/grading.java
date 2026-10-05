import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] scores = new int[3][N];
        int[] sum = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                scores[i][j] = value;
                sum[j] += value;
            }
            checkRank(sb, scores[i]);
        }
        checkRank(sb, sum);
        System.out.println(sb);
    }

    static void checkRank(StringBuilder sb, int[] scores){
        int n = scores.length;
        int[] sorted = scores.clone();
        Arrays.sort(sorted);

        Map<Integer,Integer> rankMap = new HashMap<>();
        int rank = 1;

        for(int i=n-1; i>=0; i--){
            rankMap.putIfAbsent(sorted[i], rank++);
        }
        for(int s : scores)
            sb.append(rankMap.get(s)).append(" ");

        sb.append("\n");
    }
}