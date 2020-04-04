import java.util.Scanner;

public class Q_7568 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		int person[][] = new int[num][2]; 
		int rank[] = new int[num]; 

		for (int i = 0; i < num; i++) {
			rank[i] = 1; // 1등으로 초기화
			person[i][0] = sc.nextInt(); // 무게
			person[i][1] = sc.nextInt(); // 키
		}
		sc.close();
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j ++) {
				if (person[i][0] > person[j][0] && person[i][1] > person[j][1])
					rank[j] ++;
				// i 사람의 무게와 키가 j 사람보다 크다면 (= 덩치가 크다면), 작은 덩치 사람의 순위를 올려주기	
			}
		}
		
		for (int i = 0; i < rank.length; i++) {
			sb.append(rank[i] + " ");
		}
		System.out.println(sb);
		
	}
}