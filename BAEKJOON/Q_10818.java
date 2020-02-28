import java.io.*;
import java.util.Arrays;

public class Q_10818 {
	public static void main(String args[]) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(bf.readLine());
		String[] input = bf.readLine().split(" ");
		int[] temp = new int[case_num];
		for (int i=0;i< case_num;i++) {
			temp[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(temp);
		System.out.println(temp[0] +" "+temp[temp.length -1]);
		
	}
}