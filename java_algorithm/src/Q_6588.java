import java.util.Scanner;

public class Q_6588 {

	static int MAX = 1000000;
	static boolean[] table = new boolean[MAX];

	static boolean isPrime(int k) {
		for (int i = 2; i * i <= k; ++i) {
			if (k % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		table[1] = true;
		for (int i = 2; i < MAX; i++) {
			table[i] = isPrime(i);
		}

		while (true) {
			int A = sc.nextInt();

			if (A == 0)
				System.exit(0);

			int leftnum = 2;

			while (true) {
				int rightnum = A - leftnum;
				if (leftnum > A / 2) {
					System.out.println("Goldbach's conjecture is wrong.");
					break;
				}

				if (table[leftnum] && table[rightnum]) {
					System.out.println(A + " = " + leftnum + " + " + rightnum);
					break;
				}

				else
					leftnum++;

			}

		}
	}

}
