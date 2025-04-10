class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
		
		for(char ch : s.toCharArray()) {
			int v = ' ';
			if(Character.isUpperCase(ch)) {
				v = ch+n;
				
				if(v>'Z')
					v = v-'Z'+'A'-1;
				
				sb.append((char)v);
			}
			else if(Character.isLowerCase(ch)){
				v = ch+n;
				
				if(v>'z')
					v = v-'z'+'a'-1;
				
				sb.append((char)v);
			}
			else 
				sb.append(" ");
		}
        return sb.toString();
    }
}