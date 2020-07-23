import java.util.Scanner;

public class Q_15989 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        int[][] dp=new int[10001][4];
        dp[1][1]=1; dp[2][1]=1; dp[2][2]=1; dp[3][1]=2; dp[3][3]=1;
        for(int i=4; i<=10000; i++) {
            dp[i][1]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
            dp[i][2]=dp[i-2][2]+dp[i-2][3];
            dp[i][3]=dp[i-3][3];
        }
        for(int tc=1; tc<=T; tc++) {
            int N=sc.nextInt();
            System.out.print(dp[N][1]+dp[N][2]+dp[N][3]+"\n");
        }
    }

}