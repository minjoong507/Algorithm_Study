import java.io.*;
import java.util.*;

public class Q_13460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, r_x, r_y, b_x, b_y;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][N][M];

        for(int i = 0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<M; j++) {
                switch (tmp[j]) {
                    case '#':
                        map[i][j] = -1;
                        break;
                    case '.':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        r_x = j;
                        r_y = i;
                        break;
                    case 'B':
                        map[i][j] = 2;
                        b_x = j;
                        b_y = i;
                        break;
                    case 'O':
                        map[i][j] = 3;
                        break;
                }

            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Deque<balls> q = new ArrayDeque<>();
        q.offer(new balls(r_x,r_y,b_x,b_y,0));
        visited[r_y][r_x][b_y][b_x] = true;

        while(!q.isEmpty()){

            balls val = q.poll();
            if(val.cnt > 10) continue;
            if(map[val.by][val.bx] == 3) continue;
            if(map[val.ry][val.rx] == 3) return val.cnt;

            for(int i = 0; i<4; i++){
                //빨간공 이동
                int next_rx = val.rx, next_ry = val.ry;
                while(true){
                    if(map[next_ry][next_rx] != 3 && map[next_ry][next_rx] != -1){
                        next_rx += dx[i];
                        next_ry += dy[i];
                    }
                    else{
                        if(map[next_ry][next_rx] == -1){
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        }
                        break;
                    }
                }

                //파란공 이동
                int next_bx = val.bx, next_by = val.by;
                while(true){
                    if(map[next_by][next_bx] != 3 && map[next_by][next_bx] != -1){
                        next_bx += dx[i];
                        next_by += dy[i];
                    }
                    else{
                        if(map[next_by][next_bx] == -1){
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }
                        break;
                    }
                }

                if(next_rx == next_ry && next_ry == next_by){
                    if(map[next_ry][next_rx] != 3){
                        int red_move = Math.abs(val.rx - next_rx) + Math.abs(val.ry - next_ry);
                        int blue_move = Math.abs(val.bx - next_bx) + Math.abs(val.by - next_by);

                        if(red_move < blue_move){
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }
                        else{
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        }
                    }
                }

                if(!visited[next_ry][next_rx][next_by][next_bx]){
                    visited[next_ry][next_rx][next_by][next_bx] = true;
                    q.add(new balls(next_rx, next_ry, next_bx, next_by, val.cnt+1));
                }
            }
        }

        return -1;
    }

    public static class balls{
        int rx,ry,bx,by,cnt;

        public balls(int rx, int ry, int bx, int by, int cnt){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }

    }


}
