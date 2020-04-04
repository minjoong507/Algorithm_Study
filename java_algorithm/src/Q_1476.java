import java.util.Scanner;

public class Q_1476 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		int a = 0, b = 0, c = 0;
		int result = 0;

		while (true) {
			if (a == E && b == S && c == M) {
				System.out.println(result);
				break;
			}
			else {
				a++;
				b++;
				c++;
				result++;
				
				if (a == 16)
					a = 1;
				if (b == 29)
					b = 1;
				if (c == 20)
					c = 1;
			}

		}
	}
}
