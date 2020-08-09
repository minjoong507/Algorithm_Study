import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q_7562 {
    static class point{
        int x, y;

        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Scanner sc = new Scanner(System.in);
    static int I, target_x, target_y;
    static boolean[][] visited;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args){
        int T = sc.nextInt();

        for(int i = 0 ; i<T; i++){
            I = sc.nextInt();
            visited = new boolean[I][I];

            int x = sc.nextInt();
            int y = sc.nextInt();
            target_x = sc.nextInt();
            target_y = sc.nextInt();

            if(x == target_x && y == target_y)
                System.out.println(0);
            else
                BFS(x, y);
        }



    }

    public static void BFS(int x, int y){
        int step = 0;
        boolean ok = false;
        Deque<point> q = new ArrayDeque<>();
        q.offer(new point(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()){
            int q_size = q.size();
            for(int t = 0; t < q_size; t++){
                point p = q.poll();

//                System.out.println(p.x + " " + p.y);
                if(p.x == target_x && p.y == target_y) {
                    ok = true;
                    break;
                }
                for(int i = 0; i<8; i++){
                    int next_x = p.x + dx[i];
                    int next_y = p.y + dy[i];
                    if(bound(next_x, next_y) && !visited[next_y][next_x]){
                        visited[next_y][next_x] = true;
                        q.offer(new point(next_x, next_y));
                    }
                }


            }

            if(ok) break;
            step++;
        }
        System.out.println(step);
    }

    public static boolean bound(int x, int y){
        return x >= 0 && x < I && y >=0 && y < I;
    }

}
