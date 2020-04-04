import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Q_2562 {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		
		for(int i = 0 ; i < arr.length ; i ++)			// 배열에 9개의 수를 넣음
		{
			arr[i]=sc.nextInt();	
		}
		
		int max = arr[0];
		int index = 0;
		
		for(int i=1;i< arr.length; i++) {
			if (arr[i]>max) {
				max = arr[i];
				index = i;
			}
			
			
		}
		System.out.println(max);
		System.out.println(index+1);
		
	}
}