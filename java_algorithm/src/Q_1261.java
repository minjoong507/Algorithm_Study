import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q_1261 {
    static class point{
        int x, y, cnt;
        point(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, result = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] map, step;

    public static void main(String[] args) throws Exception{
        String[] tmp = br.readLine().split(" ");
        M = Integer.parseInt(tmp[0]);
        N = Integer.parseInt(tmp[1]);
        map = new int[N+1][M+1];
        step = new int[N+1][M+1];

        for(int i = 1; i < N+1; i++){
            String s = br.readLine();
            for(int j = 1; j < M+1; j++){
                map[i][j] = Character.getNumericValue(s.charAt(j-1));
                step[i][j] = -1;
//                System.out.print(map[i][j] + " ");
            }
        }
        step[1][1] = 0;
        BFS(new point(1, 1, 0));
        System.out.println(result);
    }

    public static void BFS(point s){
        Deque<point> q = new ArrayDeque<>();
        q.offer(s);

        while(!q.isEmpty()){
            int q_size = q.size();
            for(int i = 0; i < q_size; i++){
                point p = q.poll();
//                System.out.println(p.x + " " + p.y + " " + p.cnt);
                if(p.x == M && p.y == N){
                    result = Math.min(p.cnt, result);
                    continue;
                }

                for(int j = 0; j < 4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(0 < nx && nx <= M && 0 < ny && ny <= N){
                        if(map[ny][nx] == 0){ // 벽이 아님
                            if(step[ny][nx] == -1){ // 방문한적도 없음
                                step[ny][nx] = p.cnt;
                                q.offer(new point(nx, ny, p.cnt));
                            }

                            else{
                                if(p.cnt < step[ny][nx]){
                                    step[ny][nx] = p.cnt;
                                    q.offer(new point(nx, ny, p.cnt));
                                }
                            }
                        }

                        else{ // 벽
                            if(step[ny][nx] == -1){ // 방문한적도 없음
                                step[ny][nx] = p.cnt + 1;
                                q.offer(new point(nx, ny, p.cnt + 1));
                            }

                            else{
                                if(p.cnt + 1 < step[ny][nx]){
                                    step[ny][nx] = p.cnt + 1;
                                    q.offer(new point(nx, ny, p.cnt + 1));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
