import java.io.*;
import java.util.ArrayList;

public class Q_1316 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(bf.readLine());
		int result = 0;
		
		for (int i=0; i<A;i++) {
			boolean Isgroupword = true;
			ArrayList<Character> arr = new ArrayList<Character>();
			char[] word = bf.readLine().toCharArray();
			
			for(char temp : word) {
				if(!arr.contains(temp) || arr.get(arr.size()-1)==temp ) {
					arr.add(temp);
				}
				else {
					Isgroupword = false;
					break;
				}
			}

			if (Isgroupword) {
				result ++;
			}
		}
		System.out.println(result);

		
	}
}
