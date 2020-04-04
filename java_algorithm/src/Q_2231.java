import java.util.Scanner;

public class Q_2231 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		sc.close();
		
		for (int i = N - 1; i > 0; i--) {
			int re = i + sum_of_num(Integer.toString(i).toCharArray());
			if (re == N)
				result = i;
		}
		System.out.println(result);

	}

	public static int sum_of_num(char[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++)
			sum += Character.getNumericValue(x[i]);

		return sum;
	}

}
