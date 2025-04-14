import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {       
        int[] answer = new int[2];

		Set<String> set = new HashSet<String>();

		for (int i = 0; i < words.length; i++) {
			
			if (i == 0) {
				set.add(words[i]);
				continue;
			}
			
			char last = words[i - 1].charAt(words[i - 1].length() - 1);// 앞 마지막 글자
			char first = words[i].charAt(0); // 뒤 첫글자
			
			if (last != first || set.contains(words[i]) || words[i].length() == 1) {
				answer[0] = i % n + 1;
				answer[1] = (int) Math.ceil((i + 1) / (double)n);
                return answer;
			}
			
			set.add(words[i]);

		}

		return answer;
    }
}