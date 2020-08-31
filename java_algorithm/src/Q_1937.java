import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Q_1937 {
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int result;
    static int[][] arr, day;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        day = new int[N][N];

        for(int i = 0; i <N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j ++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
            Arrays.fill(day[i], -1);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result, panda(new point(i, j)));
            }
        }
        System.out.println(result);
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(day[i][j] + " ");
//            }
//            System.out.println("");
//        }

    }

    public static int panda(point p){
        if(day[p.y][p.x] != -1) return day[p.y][p.x];
        int temp = 1;
        for(int i = 0; i < 4; i++){
            int next_x = p.x + dx[i];
            int next_y = p.y + dy[i];

            if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                if(arr[p.y][p.x] < arr[next_y][next_x]){
                    temp = Math.max(panda(new point(next_x, next_y)) + 1, temp);
                    day[p.y][p.x] = temp;
                }
            }
        }
        return temp;
    }

}
