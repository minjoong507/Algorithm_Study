import java.util.Scanner;

public class Q_2485 {

	 private static int gcd(int a, int b) {
		  int temp;
		  while(b != 0) {
		   temp = a;
		   a = b;
		   b = temp % b;
		  }
		  
		  return a;
		 }
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int[] arr = new int[time];
		int[] diff = new int[time - 1];
		int coef = 1;
		int sum = 0;

		for (int i = 0; i < time; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < time-1; i++) 
			diff[i] = arr[i + 1] - arr[i];
		
		
		int g = gcd(diff[0], diff[1]);
		for(int i=2;i<diff.length-1;i++)
			g = gcd(g, diff[i]);


		for (int j = 0; j < diff.length; j++) {
			sum += diff[j] / g - 1;
		}
		System.out.println(sum);
	}

}
