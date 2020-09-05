import java.util.Scanner;

public class Q_14499 {
    static Scanner sc = new Scanner(System.in);
    static int N, M, y, x, K;
    static int[] dice = new int[7];
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt();
        x = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        dice[6] = map[y][x];
        map[y][x] = 0;

        for(int i = 0; i < K; i++) {
            int mv = sc.nextInt();
            if(x + dx[mv] >= 0 && x + dx[mv] < M && y + dy[mv] >= 0 && y + dy[mv] < N){
                x = x + dx[mv];
                y = y + dy[mv];
                move(mv);
            }
        }


    }

    public static void move(int dir){
        int[] new_dice = new int[7];
        for(int i = 1; i < 7; i++)
            new_dice[i] = dice[i];

        switch (dir){
            case 1: // 悼率
                if(map[y][x] == 0)
                    map[y][x] = new_dice[3];
                else{
                    new_dice[3] = map[y][x];
                    map[y][x] = 0;
                }

                dice[6] = new_dice[3];
                dice[4] = new_dice[6];
                dice[1] = new_dice[4];
                dice[3] = new_dice[1];
                break;

            case 2: // 辑率
                if(map[y][x] == 0)
                    map[y][x] = new_dice[4];
                else{
                    new_dice[4] = map[y][x];
                    map[y][x] = 0;
                }

                dice[6] = new_dice[4];
                dice[4] = new_dice[1];
                dice[1] = new_dice[3];
                dice[3] = new_dice[6];
                break;

            case 3: //合率
                if(map[y][x] == 0)
                    map[y][x] = new_dice[2];
                else{
                    new_dice[2] = map[y][x];
                    map[y][x] = 0;
                }

                dice[2] = new_dice[1];
                dice[1] = new_dice[5];
                dice[5] = new_dice[6];
                dice[6] = new_dice[2];
                break;

            case 4: // 巢率
                if(map[y][x] == 0)
                    map[y][x] = new_dice[5];
                else{
                    new_dice[5] = map[y][x];
                    map[y][x] = 0;
                }

                dice[6] = new_dice[5];
                dice[5] = new_dice[1];
                dice[1] = new_dice[2];
                dice[2] = new_dice[6];
                break;
        }
        System.out.println(dice[1]);
    }

}
