import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1330 {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] Line = bf.readLine().split(" ");
		int a = Integer.parseInt(Line[0]);
		int b = Integer.parseInt(Line[1]);
		
		if (-10000<a && a<10000 && -10000 < b && b < 10000){
			if (a<b) {
				System.out.println("<");
			}
			else if (a>b) {
				System.out.println(">");	
			}
			else {
				System.out.println("==");
			}
		
		}
		else {
			System.exit(0);
		}
	
	}
}
