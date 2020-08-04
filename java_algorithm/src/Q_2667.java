import java.io.*;
import java.util.*;

public class Q_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static ArrayList<Integer> home = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i = 1; i<arr.length; i++){
            String tmp = br.readLine();
            for(int  j = 1; j<arr[i].length; j++){
                arr[i][j] = tmp.charAt(j-1) - '0';
            }
        }
        solve();
        System.out.println(home.size());
        for(int num: home)
            System.out.println(num);
    }

    public static void solve(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    home.add(BFS(j, i));
                }
            }
        }
        Collections.sort(home);
    }

    public static int BFS(int x, int y) {
        Deque<point> q = new ArrayDeque<>();
        q.offer(new point(x, y));
        visited[y][x] = true;

        int result = 0;

        while (!q.isEmpty()) {
            point p = q.poll();
//            System.out.println("x:" + p.x + ", y: " + p.y);

            for (int k = 0; k < 4; k++) {
                int next_x = p.x + dx[k];
                int next_y = p.y + dy[k];
                if (bound(next_x, next_y) && !visited[next_y][next_x] && arr[next_y][next_x] == 1){
                    visited[next_y][next_x] = true;
                    q.offer(new point(next_x, next_y));
                }
            }
            result++;
        }

        return result;
    }

    public static boolean bound (int next_x, int next_y){
        return next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N;
    }
}
