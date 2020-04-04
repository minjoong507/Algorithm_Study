import java.util.Scanner;

public class Q_11729 {
	static int time = 0;
	static String result;
	
	public static String hanoi(int k, int start, int End) {
		
		if (k == 1) {
			result = String.format("%d %d\n", start, End);
			time ++;
			return result;
		} else {
			int tmp = 6 - (start + End);
			return hanoi(k - 1, start, tmp) + hanoi(1, start, End) + hanoi(k - 1, tmp, End);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.close();
		String result = hanoi(K,1,3);
		System.out.println(time);
		System.out.println(result);

	}
}
