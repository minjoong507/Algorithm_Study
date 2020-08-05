import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Q_7576 {

    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static Scanner sc = new Scanner(System.in);
    static int N, M, cnt = 0, visit_cnt = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] tomato;
    static boolean[][] visited;
    static ArrayList<point> start_tomato = new ArrayList<>();

    public static void main(String[] args){
        M = sc.nextInt();
        N = sc.nextInt();

        tomato = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i < tomato.length; i++){
            for(int j = 1; j < tomato[i].length; j++){
                tomato[i][j] = sc.nextInt();

                if(tomato[i][j] == 1) { // 시작점 저장
                    start_tomato.add(new point(j, i));
                    visit_cnt++;
                }

                if(tomato[i][j] == -1) { // 벽인 경우
                    visited[i][j] = true;
                    visit_cnt++;
                }
            }
        }
        BFS();
    }

    public static void BFS(){
        Deque<point> q = new ArrayDeque<>();
        boolean ok = false;

        // 시작지점 입력
        for(point p: start_tomato) {
            q.offer(p);
            visited[p.y][p.x] = true;
        }

        if(visit_cnt == N * M){
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            int s = q.size();
            cnt++;

            for(int i = 0; i<s; i++){
                point p = q.poll();

                for(int j = 0; j < 4; j++){
                    int next_x = p.x + dx[j];
                    int next_y = p.y + dy[j];

                    if(isbound(next_x, next_y) && !visited[next_y][next_x] && tomato[next_y][next_x] == 0){
                        q.offer(new point(next_x, next_y));
                        visited[next_y][next_x] = true;
                        visit_cnt++;
                    }
                }

                if(visit_cnt == M * N){
                    ok = true;
                    break;
                }

            }

            if(ok) {
                System.out.println(cnt);
                return;
            }
        }

        System.out.println(-1);

    }

    public static boolean isbound(int x, int y){
        return x > 0 && x <= M && y > 0 && y <= N;
    }

    public static boolean check_tomato(){
        for(int i = 1; i<visited.length; i++){
            for(int j = 1; j < visited[i].length; j++){
                if(!visited[i][j])
                    return false;

            }
        }
        return true;
    }

}
