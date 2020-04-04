import java.util.Scanner;

public class Q_10870 {
	public static int fibo(int x) {
		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			return fibo(x - 1) + fibo(x - 2);
		}

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		sc.close();
		System.out.println(fibo(A));

	}
}
