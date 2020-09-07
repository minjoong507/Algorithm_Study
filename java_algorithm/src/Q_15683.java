import java.util.ArrayList;
import java.util.Scanner;

public class Q_15683 {
    static class cc{
        int x, y, type;
        cc(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static int[] dx = {0, 1, 0, -1}; // ºÏ µ¿ ¼­ ³²
    static int[] dy = {-1, 0, 1, 0}; // ºÏ µ¿ ¼­ ³²
    static int[][] map;
    static ArrayList<cc> cctv = new ArrayList<>();

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int input = sc.nextInt();

                if(input == 0)
                    map[i][j] = 0;
                else if(input == 6)
                    map[i][j] = -1;
                else {
                    cctv.add(new cc(j, i, input));
                    map[i][j] = 1;
                }
            }
        }
        solve();
    }

    public static void solve(){
        for(cc c: cctv){
            int result = 0;
            int max_dir = -1;
            int min_result = Integer.MAX_VALUE;
            switch (c.type){
                case 1:
                    for(int i = 0; i < 4; i++){
                        int tmp = check_map(c.x, c.y, i);
                        if(result < tmp){
                            max_dir = i;
                            result = tmp;
                        }
                    }
                    if(max_dir == -1)
                        break;

                    draw_map(c.x, c.y, max_dir);
                    break;

                case 2:
                    if(check_map(c.x, c.y, 0) + check_map(c.x, c.y, 2) > check_map(c.x, c.y, 1) + check_map(c.x, c.y, 3)){
                        draw_map(c.x, c.y, 0);
                        draw_map(c.x, c.y, 2);
                    }
                    else{
                        draw_map(c.x, c.y, 1);
                        draw_map(c.x, c.y, 3);
                    }
                    break;

                case 3:
                    for(int i = 0; i < 4; i++){
                        int tmp = check_map(c.x, c.y, i) + check_map(c.x, c.y, (i+1) % 4);
                        if(result < tmp){
                            max_dir = i;
                            result = tmp;
                        }
                    }
                    if(max_dir == -1)
                        break;
                    draw_map(c.x, c.y, max_dir);
                    draw_map(c.x, c.y, (max_dir + 1) % 4);
                    break;

                case 4:
                    for(int i = 0; i < 4; i++){
                        int tmp = check_map(c.x, c.y, i);
                        if(min_result > tmp){
                            max_dir = i;
                            min_result = tmp;
                        }
                    }

                    for(int i = 0; i < 4; i++){
                        if(i != max_dir)
                            draw_map(c.x, c.y, i);
                    }
                    break;

                case 5:
                    for(int i = 0; i < 4; i++)
                            draw_map(c.x, c.y, i);
                    break;
            }
        }

        int block = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0)
                    block ++;
//                System.out.print(map[i][j] +" ");
            }
//            System.out.println("");
        }
        System.out.println(block);
    }

    public static int check_map(int x, int y, int dir){
        int cnt = 0;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(nx >= 0 && nx < M && ny >= 0 && ny < N){
            if(map[ny][nx] == 0)
                cnt ++;
            else if(map[ny][nx] == -1)
                break;

            nx = nx + dx[dir];
            ny = ny + dy[dir];
        }

        return cnt;
    }

    public static void draw_map(int x, int y, int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(nx >= 0 && nx < M && ny >= 0 && ny < N){
            if(map[ny][nx] == 0 || map[ny][nx] == 1)
                map[ny][nx] = 1;
            else
                break;

            nx = nx + dx[dir];
            ny = ny + dy[dir];
        }

    }


}
