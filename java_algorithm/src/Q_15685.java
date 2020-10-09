import java.io.*;
import java.util.ArrayList;

public class Q_15685 {
    static class dragon_curv{
        int x, y, d, g;
        dragon_curv(int x, int y, int d, int g){
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }
    static ArrayList<dragon_curv> dragon = new ArrayList<>();
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String[] tmp = br.readLine().split(" ");
            dragon.add(new dragon_curv(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3])));
        }
        fill_dragoncurv();
        check_map();
    }

    public static void check_map(){
        int cnt = 0;
        for(int i = 0; i < map.length-1; i++){
            for(int j = 0; j < map[i].length-1; j++){
                if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void draw_map(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static String generate_dragoncurv(String curv, int g){
        if(g == 0){
            return curv;
        }
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < curv.length(); i++){
            char idx = curv.charAt(i);
            if(idx == 'X')
                tmp.append("X+YF");
            else if(idx == 'Y')
                tmp.append("FX-Y");
            else
                tmp.append(idx);
        }
        return generate_dragoncurv(tmp.toString(), g - 1);
    }

    public static void fill_dragoncurv(){
        for(dragon_curv dc: dragon){
            String CurvString = generate_dragoncurv("FX", dc.g);
            draw_dragoncurv(CurvString, dc.x, dc.y, dc.d);
        }
    }

    public static void draw_dragoncurv(String curv, int x, int y, int d){
//        System.out.println(curv);
        int nx = x;
        int ny = y;
        int dir = d;
        map[ny][nx] = 1;
        for(int i = 0; i < curv.length(); i++){

            char c = curv.charAt(i);
            switch (c){
                case 'F':
//                    System.out.println("x : " + nx + " y : " + ny);
                    nx = nx + dx[dir];
                    ny = ny + dy[dir];
                    map[ny][nx] = 1;
                    break;
                case '+':
                    dir = (dir + 1) % 4;
                    break;
                case '-':
                    if (dir - 1 < 0)
                        dir = 3;
                    else
                        dir = dir - 1;
                    break;
            }
        }
    }
}
