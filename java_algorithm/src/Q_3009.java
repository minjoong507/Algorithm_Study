import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_3009 {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		int i = 0;
		while(i++<3) {
			line = bf.readLine().split(" ");
			if(!arr1.contains(line[0])) {
				arr1.add(line[0]);
			}
			else {
				arr1.remove(line[0]);
			}
			if(!arr2.contains(line[1])) {
				arr2.add(line[1]);
			}
			else {
				arr2.remove(line[1]);
			}
		}
		System.out.println(arr1.get(0) + " " + arr2.get(0));
	}
}
