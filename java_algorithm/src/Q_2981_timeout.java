import java.util.Arrays;
import java.io.*;

public class Q_2981_timeout {
	static int rest;
	static boolean isM;
	
	public static void main(String args[]) throws Exception{
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
		for (int i = 2; i <= arr[1]; i++) {
			rest = arr[0] % i;
			isM = true;
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] % i == rest)
					continue;
				else {
					isM = false;
					break;
				}
			}
			if (isM) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb);
	}
}
