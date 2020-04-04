import java.util.Scanner;

public class Q_1436 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int temp = 0;
		String start = "665";
		
		while (temp < N) {
			start = add(start);

			if (checknum(start))
				temp++;

		}
		;
		System.out.println(start);

	}

	public static String add(String x) {
		return String.valueOf(Integer.parseInt(x) + 1);
	}

	public static boolean checknum(String x) {
		int count = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '6')
				count++;
			else
				count = 0;

			if (count == 3)
				return true;
		}
		return false;
	}

}
