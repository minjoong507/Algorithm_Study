import java.io.*;

public class Q_1495 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    static int[] arr;
    static int N, S, M;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        S = Integer.parseInt(tmp[1]);
        M = Integer.parseInt(tmp[2]);

        dp = new int[N+1][M+1];
        dp[0][S] = 1;
        arr = new int[N+1];
        tmp = br.readLine().split(" ");

        for(int i = 1; i < N+1; i++)
            arr[i] = Integer.parseInt(tmp[i-1]);

        guitar();
        answer();

    }

    public static void guitar(){
        for(int i = 1; i < N+1; i ++){
            for(int j = 0; j < M+1; j++){
                if(dp[i-1][j] == 1){
                    if(j + arr[i] <= M) dp[i][j+arr[i]] = 1;
                    if(j - arr[i] >= 0) dp[i][j-arr[i]] = 1;
                }
            }
        }
    }

    public static void answer(){
        boolean ok = true;
        for(int i = M; i >= 0; i--){
            if(dp[N][i] == 1) {
                System.out.println(i);
                ok = false;
                break;
            }
        }
        if (ok)
            System.out.println(-1);
    }
}
