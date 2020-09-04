import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q_17472 {
    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class land{
        int land_num, weight;
        land(int land_num, int weight){
            this.land_num = land_num;
            this.weight = weight;
        }
    }

    static int[][] map, island;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int N, M, island_cnt = 1;
    static ArrayList<ArrayList<land>> bridge = new ArrayList<>();
    static int result = Integer.MAX_VALUE, prev_min = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        map = new int[N][M]; // 0, 1로 섬을 구분
        island = new int[N][M]; // 섬의 좌표에 같은 숫자를 저장

        for(int i = 0; i < N; i++){
            tmp = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
//        drawmap();
        fill_island(); // 섬에 번호 매기기

        for(int i = 0; i < island_cnt + 1; i++)
            bridge.add(new ArrayList<land>());
        boolean[] visited = new boolean[island_cnt+1];

        drawisland();
        connect_right();
        connect_down();
//        drawisland();
//        visited[1] = true;
        island_cnt = island_cnt - 1;

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);

    }

    public static void fill_island(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && island[i][j] == 0){
                    BFS_island(new point(j, i));
                    island_cnt++;
                }
            }
        }
    }

    public static void MST(land l, int cnt){
        if(cnt == island_cnt)
            return;

        int next_land_num = 0;
        int min_weight = Integer.MAX_VALUE;

        for(land next_land: bridge.get(l.land_num)){
            if(next_land.weight < min_weight){
                min_weight = next_land.weight;
                next_land_num = next_land.land_num;
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
                if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N){
                    if(map[next_y][next_x] == 1 && island[next_y][next_x] == 0){
                        island[next_y][next_x] = island_cnt;
                        q.offer(new point(next_x, next_y));
                    }
                }
            }
        }
    }

    public static void connect_right(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M-1; j++){
                if(map[i][j] == 1 && map[i][j+1] == 0){
                    int length = 0;
                    int start = j;
                    while(island[i][start+1] == 0 && start < M-2){
                        length++;
                        start++;
                    }
                    if(length > 1 && map[i][start+1] != 0){
                        boolean isok = true;
                        int start_land = island[i][j];
                        int destination_land = island[i][start+1];
                        for(land l: bridge.get(start_land)){
                            if(l.land_num == destination_land){
                                isok = false;
                                break;
                            }
                        }

                        if(isok){
                            bridge.get(start_land).add(new land(destination_land, length));
                            bridge.get(destination_land).add(new land(start_land, length));
                            System.out.println(start_land + " right to " + destination_land + " " + length);
                        }
                    }
                }
            }
        }
    }

    public static void connect_down(){
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N-1; i++){
                if(map[i][j] == 1 && map[i+1][j] == 0){
                    int length = 0;
                    int start = i;
                    while(map[start+1][j] == 0 && start < N-2){
                        length++;
                        start++;
                    }
                    if(length > 1 && map[start+1][j] != 0){
                        boolean isok = true;
                        int start_land = island[i][j];
                        int destination_land = island[start+1][j];
                        for(land l: bridge.get(start_land)){
                            if(l.land_num == destination_land){
                                isok = false;
                                break;
                            }
                        }
                        if(isok){
                            bridge.get(start_land).add(new land(destination_land, length));
                            bridge.get(destination_land).add(new land(start_land, length));
                            System.out.println(start_land + " down to " + destination_land + " " + length);
                        }

                    }
                }
            }
        }
    }



    public static void drawisland(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(island[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void drawmap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}
