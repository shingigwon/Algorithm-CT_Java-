import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] charArrays = new char[N][];

        for(int i=0; i<N; i++){
            charArrays[i] = br.readLine().replaceAll("\\s", "").toCharArray();
        }
        Map<Character, Integer> map = new HashMap<>();

        for(int j=0; j<charArrays.length; j++){
            for(int k=0; k< charArrays[j].length; k++){
                int count = map.getOrDefault(charArrays[j][k], 0) + 1;
                map.put(charArrays[j][k], count);
            }
            int max = Integer.MIN_VALUE;
            char frequent = ' ';
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    frequent = entry.getKey();

                } else if (entry.getValue() == max) {
                    frequent = '?';
                }
            }
            System.out.println(frequent);
            map.clear();
        }

        br.close();
    }
}

