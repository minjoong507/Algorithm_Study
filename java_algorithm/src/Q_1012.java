import java.util.Scanner;

public class Q_1012 {
    static Scanner sc = new Scanner(System.in);
    static int T, M, N, K, result;
    static int[][] ground;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args){
        T = sc.nextInt();

        for(int i = 0; i<T; i++){
            result = 0;

            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            ground = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j<K;j ++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                ground[y][x] = 1;
            }

            solve();
            System.out.println(result);
        }


    }

    public static void solve(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(ground[i][j] == 1){
                    ground[i][j] = 0;
                    visited[i][j] = true;
                    DFS(j, i);
                    result++;

//                    System.out.println(j + ", " + i);
                }
            }
        }


    }

    public static void DFS(int x, int y){
        for(int i = 0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(bound(next_x, next_y) && ground[next_y][next_x] == 1 && !visited[next_y][next_x]){
                ground[next_y][next_x] = 0;
                visited[next_y][next_x] = true;
                DFS(next_x, next_y);
            }

        }

    }

    public static boolean bound(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }

}
