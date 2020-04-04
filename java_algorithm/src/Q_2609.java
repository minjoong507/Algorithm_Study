import java.util.Scanner;

public class Q_2609 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		System.out.println(GCD(A, B));
		System.out.println(A * B / GCD(A, B));
	}

	public static int GCD(int a, int b) {
		while (b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

}
