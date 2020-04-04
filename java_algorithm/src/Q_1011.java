import java.util.Scanner;

public class Q_1011 {
	public static int fibo(int x) {
		int sum = 0;
		for(int i =1; i<x+1;i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		
		for (int i =0;i<time;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int distance = B-A;
			int now = 0;
			int result = 0;
			
			while (distance > now) {
				result++;
				now += result / 2;
			}
			System.out.println(result-1);		}
		
	}
}
