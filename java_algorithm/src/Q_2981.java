import java.util.Arrays;
import java.io.*;

public class Q_2981 {
	public static int findGcd(int a, int b) {
		while (b != 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringBuilder sb = new StringBuilder();
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}
		Arrays.sort(arr);
		int gcd = arr[1] - arr[0];

		for (int j = 2; j < arr.length; j++) {
			gcd = findGcd(Math.max(gcd, arr[j] - arr[j-1]),
					Math.min(gcd, arr[j] - arr[j-1]));
		}

		for (int i=2; i<=gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i).append(' ');
            }
        }
		System.out.println(sb);
	}
}
