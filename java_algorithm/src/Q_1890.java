import java.util.Scanner;
import java.util.Stack;

public class Q_1890 {
    static Scanner sc = new Scanner(System.in);
    static int[][] map;
    static int N;
    static long[][] result;

    public static void main(String[] args){
        N = sc.nextInt();
        map = new int[N+1][N+1];
        result = new long[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++)
                map[i][j] = sc.nextInt();
        }

        solve();
        System.out.println(result[N][N]);
    }

    public static void solve(){
        result[1][1] = 1;
        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<N+1; j++){
                if(i == N && j == N)
                    break;

                if(i + map[i][j] < N + 1)
                    result[i + map[i][j]][j] += result[i][j];

                if(j + map[i][j] < N + 1)
                    result[i][j + map[i][j]] += result[i][j];
            }

        }

    }
}