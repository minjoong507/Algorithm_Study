import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q_2206 {
    static class point{
        int x, y, cnt, crush;
        point(int x, int y,int cnt, int crush){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crush = crush;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for(int i = 1; i <= N; i++){
            input = br.readLine().split("");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        BFS(new point(1, 1, 1, 0));
    }

    public static void BFS(point start){
        Deque<point> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.y][start.x][0] = true;
        visited[start.y][start.x][1] = true;

        while(!q.isEmpty()){
            int q_size = q.size();
            for(int k = 0; k < q_size; k++){
                point p = q.poll();
                if(p.x == M && p.y == N){
                    System.out.println(p.cnt);
                    return;
                }
                for(int i = 0; i < 4; i ++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(0 < nx && nx <= M && 0 < ny && ny <= N){
                        if(map[ny][nx] == 1) {
                            if(p.crush == 0 && !visited[ny][nx][1]){
                                visited[ny][nx][1] = true;
                                q.offer(new point(nx, ny, p.cnt + 1, 1));
                            }
                        }
                        else{
                            if(!visited[ny][nx][p.crush]) {
                                visited[ny][nx][p.crush] = true;
                                q.offer(new point(nx, ny, p.cnt + 1, p.crush));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

}
