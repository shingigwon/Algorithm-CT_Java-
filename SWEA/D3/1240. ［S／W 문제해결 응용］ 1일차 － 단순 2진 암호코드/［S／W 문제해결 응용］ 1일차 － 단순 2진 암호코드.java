import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean check = true;
			int ret = 0;
			
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				
				if(input.contains("1")) {
					int end = input.lastIndexOf("1");
					int start = end-56+1;
					
					String str = input.substring(start,end+1);
					int[] nums = new int[8];
					for(int j=0; j<nums.length; j++) {
						String code = str.substring(j*7, (j+1)*7);
						
						if(!map.containsKey(code)) {
							check = false;
							break; 
						}
						nums[j] = map.get(code);
					}
					
					if(check) {
						int odd = 0;
						int sum = 0;
						
						for(int j=0; j<nums.length; j++) {
							if(j%2==0)
								odd+=nums[j];
							else
								sum+=nums[j];
						}
						if((odd*3+sum)%10==0)
							ret = odd+sum;
					}
				}
			}	
			
			
			System.out.printf("#%d %d\n",t,ret);
		}
		
		br.close();
	}
}	




