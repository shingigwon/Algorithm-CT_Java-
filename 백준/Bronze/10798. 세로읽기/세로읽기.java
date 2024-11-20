import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        String[][] strings = new String[5][];
        int max=0;
        
        for (int i = 0; i < 5; i++) {
            strings[i] = br.readLine().split("");
            max = Math.max(max, strings[i].length);
        }
        
        for (int i = 0; i < max; i++) {
        	for (int j = 0; j < strings.length; j++) {
        		 if (i < strings[j].length) {
                     sb.append(strings[j][i]);
                 }
			}
		}

		System.out.println(sb.toString());
		br.close();

	}

}
