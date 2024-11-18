import java.io.*;

//1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
//2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
//3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String vowels = "aeiou";

		while (true) {
			boolean ischeck = true;
			int Vcnt = 0;
			int Ccnt = 0;
			
			String str = br.readLine();

			if (str.equals("end")) {
				break;
			}

			if (!str.matches(".*[" + vowels + "].*")) {
				ischeck = false;
			}
			if (ischeck) {
				for (int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);

					// 3.
					if (i > 0 && ch == str.charAt(i - 1)) {
						// 'e'나 'o' 이외의 같은 글자는 연속될 수 없다.
						if (!(ch == 'e' || ch == 'o')) {
							ischeck = false;
							break;
						}
						
					}

					if (vowels.indexOf(ch) >= 0) {
						Vcnt++;
						Ccnt = 0;
					} else {
						Ccnt++;
						Vcnt = 0;
					}

					// 2
					if (Vcnt == 3 || Ccnt == 3) {
						ischeck = false;
						break;
					}

				}

			}

			System.out.println(String.format("<%s> is %sacceptable.", str, ischeck ? "" : "not "));

		}
		br.close();
	}

}
