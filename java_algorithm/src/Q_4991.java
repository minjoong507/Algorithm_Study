import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class robot{
    int x, y, cnt, clean;

    robot(int x, int y, int cnt, int clean){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.clean = clean;
    }
}



public class Q_4991 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, Map_size;
    static int[][] map;
    static ArrayList<point> mass = new ArrayList<>();
    static robot start;

    public static void main(String[] args) throws Exception{
        String[] tmp = br.readLine().split(" ");
        w = Integer.parseInt(tmp[0]);
        h = Integer.parseInt(tmp[1]);
        map = new int[h][w];
        Map_size = w * h;

        for(int col = 0; col <h; col++){
            char[] map_info = br.readLine().toCharArray();
            for(int row = 0; row < map[col].length; row++){
                // 빈 공간
                if (map_info[row] == '.') map[row][col] = 0;

                    // 먼지
                else if (map_info[row] == '*'){
                    mass.add(new point(row, col));
                    map[col][row] = 2;
                }

                // 시작
                else if (map_info[row] == 'o'){
                    start = new robot(row, col, 0, 0);
                    map[col][row] = 0;
                }

                // 벽
                else if (map_info[row] == 'x') map[col][row] = 1;

            }

        }

        solve();
    }

    public static void solve(){
        Deque<robot> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){


        }




    }




}
