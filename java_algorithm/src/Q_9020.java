import java.util.Scanner;

public class Q_9020 {

	static int MAX = 10001;
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
		int Test_case = sc.nextInt();

		table[1] = true;
		for (int i = 2; i < MAX; i++) {
			table[i] = isPrime(i);
		}

		for (int i = 0; i < Test_case; i++) {
			int A = sc.nextInt();
			int leftnum = A/2;
			int rightnum = A/2;

			
			while (true) {
				if (table[leftnum] && table[rightnum]) {
					break;
				}
				else {
					leftnum --;
					rightnum ++;
				}
			}
			
		
			System.out.println(leftnum + " " + rightnum);
		}
	}

}
