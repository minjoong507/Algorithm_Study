import java.util.Arrays;
import java.util.Scanner;

public class Q_1085 {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		arr[0] = sc.nextInt();
		
		arr[1] = sc.nextInt();
		
		int w = sc.nextInt();
		arr[2] =  w - arr[0];
		
		int h = sc.nextInt();
		arr[3] =  h - arr[1];

		Arrays.sort(arr);
		System.out.println(arr[0]);
		
		
	}
}
