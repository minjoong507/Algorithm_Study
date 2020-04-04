import java.util.Arrays;
import java.util.Scanner;

public class Q_2309 {
	static int[] tall;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		tall = new int[9];
		int sum = 0;
		for (int i = 0; i < tall.length; i++) {
			tall[i] = sc.nextInt();
			sum += tall[i];
		}

		sc.close();
		Arrays.sort(tall);
		for (int i = 0; i < tall.length - 1; i++) {
			for (int j = i + 1; j < tall.length; j++) {
				// 차가 100이 될 친구를 찾자
				if (sum - tall[i] - tall[j] == 100) {
					for (int k = 0; k < tall.length; k++) {
						if (k != i && k != j)
							System.out.println(tall[k]);
					}
					System.exit(0);
				}

			}

		}

	}

}
