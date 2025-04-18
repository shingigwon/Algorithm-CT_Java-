import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringBuilder sb = new StringBuilder();
			String input = br.readLine();
			
			String MM = input.substring(4,6);
			String DD = input.substring(6,8);
			int M =Integer.parseInt(MM);
			int D = Integer.parseInt(DD);
			
			switch(M) {
			case 1:
				if(1>D||D>31) 
					sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);
				break;
				
			case 2:
				if(1>D||D>28) 
					sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);
				break;
				
			case 3:
				if(1>D||D>31) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				break;
			case 4:
				if(1>D||D>30) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 5:
				if(1>D||D>31) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 6:
				if(1>D||D>30) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 7:
				if(1>D||D>31) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 8:
				if(1>D||D>31) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 9:
				if(1>D||D>30) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 10:
				if(1>D||D>31) sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
			case 11:
				if(1>D||D>30)  sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				break;
			case 12:
				if(1>D||D>31)  sb.append(-1);
				else
					sb.append(input.substring(0,4)).append("/").append(MM).append("/").append(DD);				
				break;
				default:{
					sb.append(-1);
					break;
				}
			}
			System.out.printf("#%d %s\n",t,sb.toString());
		}
		br.close();

	}
}