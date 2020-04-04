import java.util.Arrays;
import java.util.Scanner;

public class Q_4153 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			double[] arr = new double[3];
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();

			if (x == 0 && y == 0 && z == 0) {
				break;
			} else {
				arr[0] = Math.pow(x, 2);
				arr[1] = Math.pow(y, 2);
				arr[2] = Math.pow(z, 2);
				Arrays.sort(arr);

				if (arr[0] + arr[1] == arr[2]) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}

			}

		}

	}
}
