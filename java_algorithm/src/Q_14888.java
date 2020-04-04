import java.util.Scanner;

public class Q_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int N;
	static int[] number;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N];

		for (int i = 0; i < N; i++)
			number[i] = sc.nextInt();

		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int multi = sc.nextInt();
		int divi = sc.nextInt();
		sc.close();

		int[] operator = { plus, minus, multi, divi };
		solve(1, number[0], operator);

		System.out.println(max);
		System.out.println(min);

	}

	public static void solve(int step, int sum, int[] op) {
		if (step == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < op.length; i++) {
			if (op[i] > 0) {
				op[i] -= 1;
				switch (i) {
				case 0:
					solve(step + 1, sum + number[step], op);
					break;

				case 1:
					solve(step + 1, sum - number[step], op);
					break;

				case 2:
					solve(step + 1, sum * number[step], op);
					break;

				case 3:
					solve(step + 1, sum / number[step], op);
					break;
				}
				op[i] += 1;
			}

		}

	}

}
