import java.util.Scanner;

public class Q_10872 {
	public static int fact(int x) {
		if (x == 1) {
			return 1;
		} else {
			return (int)(fact(x - 1) * x);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		sc.close();
		if (A == 0) {
			System.out.println(1);
		}
		else {
			int ans = fact(A);
			System.out.println(ans);
		}
	}
}
