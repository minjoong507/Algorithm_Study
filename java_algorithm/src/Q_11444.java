import java.util.Scanner;

public class Q_11444 {
	static long mod = 1000000007;
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong()-1;
		long originalN = n+1;
		
		
		long[][] matrix = { {1, 1}, {1, 0} };
		long[][] ansMatrix = { {1, 0}, {0, 1} };

		while(n>0){
			if(n%2==1) ansMatrix = matrixMultiply(ansMatrix, matrix);
			matrix = matrixMultiply(matrix, matrix);
			n/=2;
			System.out.println(n + " " + ansMatrix[0][0]);
		}
		if(originalN<3){
			System.out.print(1);
		}else{
			System.out.print((ansMatrix[1][0]+ansMatrix[1][1])%mod);
		}
	}
	
	public static long[][] matrixMultiply(long[][] matrix1, long[][] matrix2){
		int m1 = matrix1.length;
		int n1 = matrix1[0].length;
		int m2 = matrix2.length;
		int n2 = matrix2[0].length;
		long[][] temp = new long[m1][n2];
		
		for(int i=0; i<m1; i++){
			for(int j=0; j<n2; j++){
				for(int k=0; k<n1; k++){
					temp[i][j] += matrix1[i][k]*matrix2[k][j];
				}
				temp[i][j]%=mod;
			}
		}
		return temp;
	}
}