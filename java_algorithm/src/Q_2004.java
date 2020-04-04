import java.util.Scanner;

public class Q_2004 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		long B = sc.nextLong();
		long A = sc.nextLong();
		long C = B-A;
		
		long five = fivesearch(B);
		long two = twosearch(B);
		
		long five_2 = fivesearch(A);
		long two_2 = twosearch(A);

		long five_3 = fivesearch(C);
		long two_3 = twosearch(C);
		
		
		System.out.println(Math.min(five - (five_2 + five_3),
				two - (two_2 + two_3)));	
	}
	
	public static long fivesearch(long x) {
		long count= 0;
		
		for(long i = 5; i<=x; i= i*5)
			count += x/i;
		
		return count;
	}
	
	public static long twosearch(long x) {
		long count= 0;
		
		for(long i = 2; i<=x; i= i*2)
			count += x/i;
		
		return count;
	}
	
}