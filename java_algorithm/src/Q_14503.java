import java.io.*;
import java.util.*;

public class Q_14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, dir;
    static int[][] MAP;
    static StringTokenizer st;

    // 0:북, 1:동, 2:남, 3:서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][M];

        st = new StringTokenizer(br.readLine().trim());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        System.out.println(dir);
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j< M; j++){
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        solve(r,c, 0);

        for(int i = 0; i< MAP.length; i++){
            for(int j =0 ; j< MAP[i].length; j++){
                if(MAP[i][j] == 2)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void solve(int x, int y, int rotate){

        if(rotate == 4){
            if(MAP[y-dy[dir]][x-dx[dir]] != 1)
                solve(x - dx[dir], y - dy[dir],0);
            else
                return;
        }
        else{
            if(MAP[y][x] == 0) MAP[y][x] = 2;

            dir = changDir(dir);
            // 왼쪽에 청소할 곳이 있음.
            if(MAP[y + dy[dir]][x + dx[dir]] == 0){
                solve(x + dx[dir], y + dy[dir],0);
            }
            else {

                solve(x, y,rotate + 1);
            }
        }
    }

    public static int changDir(int dir){
        return (dir == 0)? 3 : dir-1;
    }

}
