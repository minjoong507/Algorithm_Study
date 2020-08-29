import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, safe = Integer.MIN_VALUE;
    static int[][] arr, test_arr, water_distance, wall_distance;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        water_distance = new int[N+1][N+1];
        wall_distance = new int[N+1][N+1];
        BFS_fill_water_distance();
        BFS_fill_wall_distance();

        for(int i = 1; i < N+1; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 1; j < N+1; j++){
                arr[i][j] =Integer.parseInt(tmp[j-1]);
            }
        }
        solve();
        if(safe == Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(safe);
    }

    public static void solve(){
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(arr[i][j] == 0 && water_distance[i][j] > wall_distance[i][j]){
                    if((i == 1 && j == 1) || (i == N && j == N))
                        continue;

                    copyarr();
                    test_arr[i][j] = 1;
                    DFS(1,1);
                    CheckSafe();
                }
            }
        }
    }

    public static void DFS(int x, int y){
        for(int i = 0; i < 4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x > 0 && next_x <= N && next_y > 0 && next_y <= N){
                if(test_arr[next_y][next_x] == 0){
                    test_arr[next_y][next_x] = 1;
                    DFS(next_x, next_y);
                }
            }
        }
    }

    public static void BFS_fill_water_distance(){
        Deque<point> q = new ArrayDeque<>();
        // visited = new boolean[N+1][N+1];
        // visited[1][1] = true;
        q.offer(new point(1,1));
        int step = 1;
        while(!q.isEmpty()){
            int q_size = q.size();
            for(int i = 0; i < q_size; i++){
                point n = q.poll();

                for(int j = 0; j < 4; j++){
                    int next_x = n.x + dx[j];
                    int next_y = n.y + dy[j];
                    if(next_x > 0 && next_x <= N && next_y > 0 && next_y <= N){
                        if(water_distance[next_y][next_x] == 0 && arr[next_y][next_x] == 0){
                            water_distance[next_y][next_x] = step;
                            q.offer(new point(next_x, next_y));
                        }
                    }
                }
            }
            step++;
        }
    }

    public static void BFS_fill_wall_distance(){
        Deque<point> q = new ArrayDeque<>();
        q.offer(new point(N, N));
        int step = 1;
        while(!q.isEmpty()){
            int q_size = q.size();
            for(int i = 0; i < q_size; i++){
                point n = q.poll();

                for(int j = 0; j < 4; j++){
                    int next_x = n.x + dx[j];
                    int next_y = n.y + dy[j];
                    if(next_x > 0 && next_x <= N && next_y > 0 && next_y <= N){
                        if(wall_distance[next_y][next_x] == 0 && arr[next_y][next_x] == 0){
                            wall_distance[next_y][next_x] = step;
                            q.offer(new point(next_x, next_y));
                        }
                    }
                }
            }
            step++;
        }
    }

    public static boolean calculate_distance(int x, int y){
        int water = x - 1 + y - 1;
        int wall = N - x + N - y;
        if(water <= wall) return false;
        else return true;

    }

    public static void copyarr(){
        test_arr = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                test_arr[i][j] = arr[i][j];
            }
        }
    }

    public static void CheckSafe(){
        int cnt = 0;
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                if(test_arr[i][j] == 0) cnt++;
            }
        }

        safe = Math.max(cnt, safe);
    }

}