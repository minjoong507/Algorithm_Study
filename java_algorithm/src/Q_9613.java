import java.util.Scanner;
import java.io.*;

public class Q_9613 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = sc.nextInt();

		for (int i = 0; i<T; i++) {
			int sum = 0;
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int j = 0; j<N; j++)
				arr[j] = sc.nextInt();
			
			for(int k = 0; k < arr.length-1; k++) {
				for(int h =k+1; h < arr.length; h++) {
					sum += GCD(arr[k], arr[h]);					
				}
			}
			System.out.println(sum);
		}
		
	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);

	}

}

