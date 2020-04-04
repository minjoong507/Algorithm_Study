import java.io.*;

public class Q_10819 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] number;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String args[]) throws Exception {

		N = Integer.parseInt(br.readLine());
		number = new int[N];
		visited = new boolean[N];
		String[] arr = br.readLine().split(" ");

		for (int i = 0; i < arr.length; i++) {
			number[i] = Integer.parseInt(arr[i]);
			visited[i] = false;
		}
		solve(new int[N], visited, 0);

		System.out.println(max);
	}

	public static void solve(int[] arr, boolean[] visited, int depth) {
		if (depth == N) {
//			for (int tmp: arr)
//				System.out.print(tmp + " ");
//			System.out.println("");
			max = Math.max(computeresult(arr), max);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = number[i];
				solve(arr, visited, depth + 1);
				visited[i] = false;
			}

		}

	}

	public static int computeresult(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++)
			sum += Math.abs(arr[i] - arr[i + 1]);

		return sum;
	}
}
