import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q_6087 {
    static class point{
        int x, y, dir, cnt;
        point(int x, int y, int dir, int cnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int W, H, target_x, target_y, result = Integer.MAX_VALUE;
    static int[][] laser;
    static ArrayList<point> start_end = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        W = Integer.parseInt(tmp[0]);
        H = Integer.parseInt(tmp[1]);
        laser = new int[H][W];

        for(int i = 0; i < laser.length; i++){
            String temp = br.readLine();
            for(int j = 0; j < laser[i].length; j++){
                if(temp.charAt(j) == 'C')
                    start_end.add(new point(j, i, 0, 0));
                else if(temp.charAt(j) == '*')
                    laser[i][j] = -1;
            }
        }
        target_x = start_end.get(0).x;
        target_y = start_end.get(0).y;
        BFS(start_end.get(1).x, start_end.get(1).y);
        System.out.println(result);
//        for(int i = 0; i < laser.length; i++){
//            for(int j = 0; j < laser[i].length; j++){
//                System.out.print(laser[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        }

    public static void BFS(int x, int y){
        Deque<point> q = new ArrayDeque<>();
        for(int i = 0; i <4; i++)
            q.offer(new point(x, y, i,1));

        while(!q.isEmpty()){
            point p = q.poll();
            if(p.x == target_x && p.y == target_y){
                result = Math.min(result, p.cnt - 1);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0 <= nx && nx < W && 0 <= ny && ny < H){
                    if(laser[ny][nx] == -1)
                        continue;
                    if(i == p.dir){ // 방향 그대로 가자.
                        if(laser[ny][nx] == 0) {
                            laser[ny][nx] = p.cnt;
                            q.offer(new point(nx, ny, i, p.cnt));
                        }
                        else{
                            if(laser[ny][nx] >= p.cnt){
                                laser[ny][nx] = p.cnt;
                                q.offer(new point(nx, ny, i, p.cnt));
                            }
                        }
                    }

                    else{ // 거울 설치하고 꺾음.
                        if(laser[ny][nx] == 0) {
                            laser[ny][nx] = p.cnt + 1;
                            q.offer(new point(nx, ny, i, p.cnt + 1));
                        }

                        else{
                            if(laser[ny][nx] > p.cnt){
                                laser[ny][nx] = p.cnt + 1;
                                q.offer(new point(nx, ny, i, p.cnt + 1));
                            }
                        }
                    }
                }
            }
        }
    }
}
