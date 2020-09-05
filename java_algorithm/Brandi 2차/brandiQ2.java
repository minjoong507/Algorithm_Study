import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class brandiQ2 {
    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, d;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        map = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[0][0] = map[0][0];
        solve();
        int result = dp[N-1][N-1];
        if(d > result)
            System.out.println(d - result);
        else
            System.out.println(-1);
    }

    public static void solve(){
        Deque<point> q = new ArrayDeque<>();
        q.offer(new point(0, 0));

        while(!q.isEmpty()){
            point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if(dp[ny][nx] == 0 || dp[ny][nx] > dp[p.y][p.x] + map[ny][nx]){
                        dp[ny][nx] = dp[p.y][p.x] + map[ny][nx];
                        q.offer(new point(nx, ny));
                    }
                }

            }
        }
    }
}