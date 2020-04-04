import java.io.*;

public class Q_2941 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] data = br.readLine().toCharArray();
		int result = 0;
		for (int i=0; i<data.length; i++) {
//			System.out.println(data[i]);
			result ++;
//			System.out.println(result);
			
			switch (data[i]) {
			
			case 'c': 
				if(i+1<data.length && (data[i+1] == '=' || data[i+1] =='-')) {
					i++;
				}
				break;
				
			case 'd':
				if(i+2<data.length && data[i+1] == 'z' && data[i+2] == '=') {
					i += 2;
				}
				else if (i+1<data.length && data[i+1] == '-') {
					i++;
				}
				break;
				
			case 'l':
				if(i+1<data.length && data[i+1] =='j') {
					i++;
				}
				break;
				
			case 'n':
				if(i+1<data.length && data[i+1] =='j') {
					i++;
				}
				break;
				
			case 's':
				if(i+1<data.length && data[i+1] =='=') {
					i++;
				}
				break;
				
			case 'z':
				if(i+1<data.length && data[i+1] =='=') {
					i++;
				}
				break;
			}
		}
		System.out.println(result);
	}
}