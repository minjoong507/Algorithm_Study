import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q_2146 {
    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map, island;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int N, island_cnt = 1;
    static int result = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        island = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }


        fill_island();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && ok_to_start(new point(j, i)))
                    BFS(new point(j, i));
            }
        }

        System.out.println(result);

    }

    public static void BFS(point p){
        Deque<point> q = new ArrayDeque<>();
        q.offer(p);
        int Land = island[p.y][p.x];
        int bridge = 0;
        visited = new boolean[N][N];
        visited[p.y][p.x] = true;

        while(!q.isEmpty()){
            if(bridge > result) break;
            int q_size = q.size();

            for(int i = 0; i < q_size; i++){
                point now = q.poll();
//                System.out.println(now.x + " " + now.y);
                for(int j = 0; j < 4; j ++){
                    int next_x = now.x + dx[j];
                    int next_y = now.y + dy[j];
                    if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                        if(!visited[next_y][next_x]){
                            if(island[next_y][next_x] == 0){
                                visited[next_y][next_x] = true;
                                q.offer(new point(next_x, next_y));
                            }
                            else if(island[next_y][next_x] != Land){
                                result = Math.min(bridge, result);
                                return;
                            }
                        }

                    }
                }


            }
            bridge++;



        }


    }

    public static void fill_island(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && island[i][j] == 0){
                    BFS_island(new point(j, i));
                    island_cnt++;
                }
            }
        }

    }

    public static void BFS_island(point p){
        Deque<point> q = new ArrayDeque<>();
        island[p.y][p.x] = island_cnt;
        q.offer(p);

        while(!q.isEmpty()){
            point now = q.poll();
            for(int i = 0; i < 4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];
                if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                    if(map[next_y][next_x] == 1 && island[next_y][next_x] == 0){
                        island[next_y][next_x] = island_cnt;
                        q.offer(new point(next_x, next_y));
                    }
                }
            }
        }
    }

    public static boolean ok_to_start(point p){
        boolean ok = false;
        for(int i = 0; i<4; i++){
            int next_x = p.x + dx[i];
            int next_y = p.y + dy[i];
            if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                if(map[next_y][next_x] == 0){
                    ok = true;
                    break;
                }
            }
        }
        return ok;
    }

    public static void drawisland(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(island[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void drawmap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
