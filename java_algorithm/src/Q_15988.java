import java.util.Scanner;

public class Q_15988 {
    static long[] dp = new long[1000001];
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] test_case;
    static long result;

    public static void main(String args[]) {
        N = sc.nextInt();
        test_case = new int[N];
        
        for (int i = 0; i < N; i++)
            test_case[i] = sc.nextInt();

        solve();

        for (int i : test_case)
            System.out.println(dp[i]);
    }

    public static void solve() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i<dp.length; i++){
            dp[i] = (dp[i] + dp[i-3]) % 1000000009;
            dp[i] = (dp[i] + dp[i-2]) % 1000000009;
            dp[i] = (dp[i] + dp[i-1]) % 1000000009;
        }
    }
}