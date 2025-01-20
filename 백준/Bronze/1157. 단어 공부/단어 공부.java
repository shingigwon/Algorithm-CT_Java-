import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Integer> map = new HashMap<>();
		String str = br.readLine();
		char frequency = ' ';

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < str.length(); i++) {

			char ch = Character.toLowerCase(str.charAt(i));
			int count = map.getOrDefault(ch, 0) + 1;

			if (count > max) {
				frequency = ch;
				max = count;
			} else if (count == max)
				frequency = '?';

			map.put(ch, count);
		}
		frequency = Character.toUpperCase(frequency);
		System.out.println(frequency);

		br.close();

	}

}
