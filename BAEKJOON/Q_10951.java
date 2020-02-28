import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_10951 {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = bf.readLine()) != null) {
			String[] input = line.split(" ");
			int a1 = Integer.parseInt(input[0]);
			int a2 = Integer.parseInt(input[1]);
			System.out.println(a1 + a2);
		}
		bf.close();
	}
}