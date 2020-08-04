import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class monkey{
    int x, y, horse;
    monkey(int x, int y, int horse){
        this.x = x;
        this.y = y;
        this.horse = horse;
    }
}

public class Q_1600 {
    static Scanner sc = new Scanner(System.in);
    static int K, W, H;
    static int[][] arr;
    static boolean[][][] visited;

    static int[] h_dx = {-1, 0, 0, 1, -2, -1, 1, 2, -2, -1, 1, 2};
    static int[] h_dy = {0, 1, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args){
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        visited = new boolean[H+1][W+1][K+1];
        arr = new int[H+1][W+1];

        for(int i = 1; i < H+1; i++){
            for(int j = 1; j < W+1; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        BFS();
    }

    public static void BFS(){
        Deque<monkey> q = new ArrayDeque<>();
        q.offer(new monkey(1, 1, K));
        boolean ispossible = false;
        int cnt = 0;

        for(int i = 0; i<=K; i++) visited[1][1][i] = true;

        while (!q.isEmpty()){
            int q_length = q.size();

            for(int j = 0; j<q_length; j++){
                monkey m = q.poll();
//                System.out.println("x :" + m.x + " y :" + m.y);
                if(m.x == W && m.y == H){
                    ispossible = true;
                    break;
                }

                for(int i = 0; i<12; i++){
                    int next_x = m.x + h_dx[i];
                    int next_y = m.y + h_dy[i];

                    if(!bound(next_x,next_y) || arr[next_y][next_x] == 1) continue;

                    if(i<4){
                        if(!visited[next_y][next_x][m.horse]){
                            visited[next_y][next_x][m.horse] = true;
                            q.offer(new monkey(next_x, next_y, m.horse));
                        }
                    }

                    else{
                        if(m.horse > 0 && !visited[next_y][next_x][m.horse-1]){
                            visited[next_y][next_x][m.horse-1] = true;
                            q.offer(new monkey(next_x, next_y, m.horse-1));
                        }
                    }

                }
            }

            if(ispossible) break;
            cnt++;
        }

        if(ispossible)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }

    public static boolean bound(int x, int y){
        return x >= 1 && x <= W && y >= 1 && y <= H;
    }
}
