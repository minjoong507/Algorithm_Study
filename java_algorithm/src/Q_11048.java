import java.util.Scanner;

public class Q_11048 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[][] map;
    static int[][] candy;
    public static void main(String args[]){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][M+1];
        candy = new int[N+1][M+1];

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                map[i][j] = sc.nextInt();
            }
        }

        solve();
        System.out.println(candy[N][M]);
    }

    public static void solve(){
        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<M+1; j++){
                if(i ==1 && j ==1)
                    candy[i][j] = map[i][j];

                else if(i == 1)
                    candy[i][j] = candy[i][j-1] + map[i][j];

                else if(j == 1)
                    candy[i][j] = candy[i-1][j] + map[i][j];

                else
                    candy[i][j] = Math.max(Math.max(candy[i-1][j], candy[i][j-1]), candy[i-1][j-1]) + map[i][j];

            }
        }
    }
}
