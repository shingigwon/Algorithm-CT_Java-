import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		Map<String, String> sToiMap = new HashMap<String,String>();
		sToiMap.put("ZRO", "0");
		sToiMap.put("ONE", "1");
		sToiMap.put("TWO", "2");
		sToiMap.put("THR", "3");
		sToiMap.put("FOR", "4");
		sToiMap.put("FIV", "5");
		sToiMap.put("SIX", "6");
		sToiMap.put("SVN", "7");
		sToiMap.put("EGT", "8");
		sToiMap.put("NIN", "9");
		
		Map<String, String> iTosMap = new HashMap<>();
		for (Map.Entry<String, String> entry : sToiMap.entrySet()) {
		    iTosMap.put(entry.getValue(), entry.getKey());
		}
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String tc = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			
			for(String s : sToiMap.keySet()) 
				input = input.replaceAll(s, sToiMap.get(s));
			
			String[] nums = input.split(" ");
			Arrays.sort(nums);
			
			StringBuilder sb = new StringBuilder();
			for(String s : nums) 
				sb.append(s).append(" ");
			
			String ret = sb.toString();
			for(String s : iTosMap.keySet()) 
				ret = ret.replaceAll(s, iTosMap.get(s));
			
			System.out.printf("%s\n%s\n",tc, ret);
		}
		br.close();
	}
}


