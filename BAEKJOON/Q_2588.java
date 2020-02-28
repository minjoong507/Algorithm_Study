import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q_2588 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] Line = bf.readLine().split("");
		String[] Line2 = bf.readLine().split("");
		int a = Integer.parseInt(Line[0]);
		int b = Integer.parseInt(Line[1]);
		int c = Integer.parseInt(Line[2]);
		
		int d = Integer.parseInt(Line2[0]);
		int e = Integer.parseInt(Line2[1]);
		int f = Integer.parseInt(Line2[2]);

		System.out.println((100*a + 10*b + c) * f);
		System.out.println((100*a + 10*b + c) * e);
		System.out.println((100*a + 10*b + c) * d);
		System.out.println((100*a + 10*b + c) * f +
				((100*a + 10*b + c) * e) * 10 +
				((100*a + 10*b + c) * d) * 100
				);
		
	}
}
