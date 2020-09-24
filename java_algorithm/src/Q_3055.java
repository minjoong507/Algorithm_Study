import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q_3055 {
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, dest_x, dest_y;
    static ArrayList<point> water_start = new ArrayList<>();
    static int[][] map, water, beaver;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new int[R][C];
        water = new int[R][C];
        beaver = new int[R][C];

        int start_x = 0, start_y = 0;

        for(int i = 0; i < R; i++){
            String tmp = br.readLine();
            for (int j = 0; j < C; j++){
                switch (tmp.charAt(j)){
                    case 'D':
                        map[i][j] = 2;
                        water[i][j] = -1;
                        dest_x = j;
                        dest_y = i;
                        break;
                    case '.':
                        map[i][j] = 0;
                        break;
                    case '*':
                        water_start.add(new point(j, i));
                        break;
                    case 'S':
                        start_x = j;
                        start_y = i;
                        break;
                    case 'X':
                        map[i][j] = -1;
                        water[i][j] = -1;
                        beaver[i][j] = -1;
                        break;
                }
            }
        }
        for(point p: water_start)
            fill_BFS(p.x, p.y, water);
        fill_BFS(start_x, start_y, beaver);

        for(int i = 0 ; i < R; i++){
            for(int j = 0; j < C; j++){
                if(beaver[i][j] < water[i][j] || map[i][j] == 2 || map[i][j] == -1 || water[i][j] == 0)
                    map[i][j] = beaver[i][j];
                else
                    map[i][j] = -1;
            }
        }
        int r = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            int nx = dest_x + dx[i];
            int ny = dest_y + dy[i];
            if(0 <= nx && nx < C && 0 <= ny && ny < R){
                if(start_x == nx && start_y == ny)
                    r = 0;
                if(map[ny][nx] != -1 && beaver[ny][nx] != 0)
                    r = Math.min(r, map[ny][nx]);
            }
        }

        if(r == Integer.MAX_VALUE)
            System.out.println("KAKTUS");
        else
            System.out.println(r + 1);
    }

    public static void fill_BFS(int x, int y, int[][] arr){
        Deque<point> q = new ArrayDeque<>();
        q.offer(new point(x, y));
        arr[y][x] = 0;
        boolean[][] visited = new boolean[R][C];

        while(!q.isEmpty()){
            point p = q.poll();
            visited[p.y][p.x] = true;
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < C && 0 <= ny && ny < R && !visited[ny][nx] && map[ny][nx] == 0){
                    if(arr[ny][nx] == 0 || arr[p.y][p.x] + 1 < arr[ny][nx]) {
                        arr[ny][nx] = arr[p.y][p.x] + 1;
                        q.offer(new point(nx, ny));
                    }
                }
            }
        }
    }
}
