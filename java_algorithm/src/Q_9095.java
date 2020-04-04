import java.util.Scanner;

public class Q_9095 {
	static int N;
	static int[] arr = { 1, 2, 3 };
	static int target;
	static int result;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int test = 0;
		while (test < N) {

			target = sc.nextInt();
			result = 0;
			solve(0);

			System.out.println(result);
			test++;
		}
		sc.close();

	}

	public static void solve(int sum) {
		if (sum == target) {
			result++;
			return;
		} else if (sum > target)
			return;

		for (int i = 0; i < arr.length; i++)
			solve(sum + arr[i]);

	}

}
