import java.util.ArrayList;
import java.util.Scanner;

public class Q_3052 {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 10 ; i ++)			
		{
			int rest =sc.nextInt() % 42;
			if (!arr.contains(rest)) {
				arr.add(rest);
			}
		}
		System.out.println(arr.size());
	}
}