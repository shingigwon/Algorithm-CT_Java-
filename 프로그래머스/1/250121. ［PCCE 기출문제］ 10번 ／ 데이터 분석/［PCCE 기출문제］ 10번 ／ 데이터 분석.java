import java.util.*;

class Solution {
static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		for(int i=0; i<data.length; i++) {
			if(data[i][cmd(ext)]<val_ext) 
				pos.add(i);
		}
		
		int[][] answer = new int[pos.size()][4];
		
		for(int i=0; i<pos.size(); i++) {
			int point = pos.get(i);
            
			for(int j=0; j<4; j++) 
				answer[i][j] = data[point][j];
		}
		
		Arrays.sort(answer, (o1, o2) -> {
		    return o1[cmd(sort_by)]-o2[cmd(sort_by)];
		});
		
		
		return answer;
	}
	
	static int cmd(String str) {
		int cmd=0;
		
		if(str.equals("code")) 
			cmd=0;
		
		else if(str.equals("date")) 
			cmd=1;
		
		else if(str.equals("maximum")) 
			cmd=2;
		
		else if(str.equals("remain")) 
			cmd=3;
		
		return cmd;
	}
}

