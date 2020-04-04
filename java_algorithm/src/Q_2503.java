import java.io.*;

public class Q_2503 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		int[] Q = new int[test_case];
		int[] S = new int[test_case];
		int[] B = new int[test_case];
		int ans = 0;

		for (int i = 0; i < test_case; i++) {
			String[] ans1 = br.readLine().split(" ");
			Q[i] = Integer.parseInt(ans1[0]);
			S[i] = Integer.parseInt(ans1[1]);
			B[i] = Integer.parseInt(ans1[2]);
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (i == j || j == k || k == i)
						continue;
					else {
						int tmp = 100 * i + 10 * j + k;
						boolean isright = true;
						for (int test = 0; test < test_case; test++) {
							if (CheckStrike(tmp, Q[test]) == S[test] && CheckBall(tmp, Q[test]) == B[test])
								continue;
							else {
								isright = false;
								break;
							}
						}

						if (isright)
							ans++;

					}

				}
			}
		}
		System.out.println(ans);
	}

	public static int CheckStrike(int x, int y) {
		int result = 0;

		if (third_place(x) == third_place(y))
			result++;

		if (second_place(x) == second_place(y))
			result++;

		if (first_place(x) == first_place(y))
			result++;

		return result;
	}

	public static int CheckBall(int x, int y) {
		int result = 0;
		if (third_place(x) != third_place(y) && 
				(third_place(x) == second_place(y) || third_place(x) == first_place(y)))
			result++;

		if (second_place(x) != second_place(y) && 
				(second_place(x) == third_place(y) || second_place(x) == first_place(y)))
			result++;

		if (first_place(x) != first_place(y) && 
				(first_place(x) == second_place(y) || first_place(x) == third_place(y)))
			result++;

		return result;
	}

	public static int third_place(int x) {
		return x / 100;
	}

	public static int second_place(int x) {
		return (x - ((x / 100) * 100)) / 10;
	}

	public static int first_place(int x) {
		return x % 10;
	}

}
