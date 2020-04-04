import java.util.Scanner;

public class Q_2798 {
	static int card_sum = 0;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card_num = new int[N];
		int close = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 0; i < N; i++)
			card_num[i] = sc.nextInt();

		sc.close();

		for (int i = 0; i < card_num.length - 2; i++) {
			for (int j = i + 1; j < card_num.length - 1; j++) {
				for (int k = j + 1; k < card_num.length; k++) {
					card_sum = card_num[i] + card_num[j] + card_num[k];

					if (card_sum <= M && M - card_sum < close) {
						close = M - card_sum;
						result = card_sum;
					}

				}
			}
		}
		System.out.println(result);
	}
}
