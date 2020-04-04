import java.util.Scanner;

public class Q_2749 {
	static int i;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);

		long r = sc.nextLong();
		sc.close();
		
		int period = 1500000;
		long[] fibo = new long[period];
		fibo[0] = 0;
		fibo[1] = 1;
		long ans = r % period;
		
		for (i=2;i<fibo.length;i++) {
			fibo[i] = (long)((fibo[i-1] + fibo[i-2]) % Math.pow(10, 6));
			if (i==ans)
				break;
		}
		System.out.println(fibo[(int)ans]);
	}
}
