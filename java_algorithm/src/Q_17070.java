import java.util.Scanner;


public class Q_17070 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] arr;
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static int result = 0;

    public static void main(String args[]){
        N = sc.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j< arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        solve(1,0,0);
        System.out.println(result);
    }


    // 0이면 가로, 1이면 세로, 2면 대각선
    public static void solve(int x, int y, int head){
        if(x == N-1 && y == N-1){
            result++;
            return;
        }


        for(int i = 0; i<dx.length;i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(head == 0 && i == 1)
                continue;
            if(head == 1 && i == 0)
                continue;


            if(next_x < N && next_y < N && arr[next_y][next_x] != 1){
                if(i == 2){
                    if(arr[y][next_x] == 1 || arr[next_y][x] == 1)
                        continue;
                }
                solve(next_x, next_y, i);

            }
        }
    }

}

