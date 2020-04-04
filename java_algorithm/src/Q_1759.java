import java.util.Arrays;
import java.io.*;

public class Q_1759 {
	static int L;
	static int C;
	static String[] code;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		code = br.readLine().split(" ");
		Arrays.sort(code);

		solve(0, "");

	}

	public static void solve(int step, String ans) {

		if (ans.length() == L) {
			if (isPossible(ans)) {
				System.out.println(ans);
			}
			return;
		}

		if (step >= C)
			return;

		solve(step + 1, ans + code[step]);
		solve(step + 1, ans);

	}

	public static boolean isPossible(String tmp) {
		int vowel = 0, consonant = 0;
		for (int i = 0; i < tmp.length(); i++) {
			if (isVowel(tmp.charAt(i)))
				vowel++;
			else
				consonant++;
		}

		return vowel >= 1 && consonant >= 2;
	}

	public static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
