import java.util.Arrays;
import java.util.Scanner;

public class Q_2805 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] tree = new int[N];

		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);
		int start = 0;
		int end = tree[tree.length - 1];

		while (start <= end) {
			int mid = (start + end) / 2;
			long length = 0;
			int diff = 0;

			for (int i = 0; i < tree.length; i++) {
				diff = tree[i] - mid;
				
				if (diff > 0)
					length += diff;
				else
					continue;
			}

			if (length >= M)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(end);
	}
}
