import java.io.*;
import java.util.*;

public class Q_3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,K,L;
    static int[][] MAP;
    static Map<Integer, Integer> move = new HashMap<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 0; // 시작 방향은 오른쪽
    static int length = 1; // 시작 뱀 길이는 1
    static Stack<Integer> root = new Stack<>();
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        // 맵, 뱀 위치 초기화
        N = Integer.parseInt(br.readLine());
        MAP = new int[N+1][N+1];
        MAP[1][1] = 1;

        // 사과
        K = Integer.parseInt(br.readLine());
        for(int t = 0; t<K; t++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 사과위치는 -1
            MAP[a][b] = -1;
        }

        // 뱀 움직임
        L = Integer.parseInt(br.readLine());
        for(int t = 0; t<L; t++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            char mv = st.nextToken().charAt(0);
            int b = 0;

            switch (mv){
                case 'L':
                    b = -1;
                    break;
                case 'D':
                    b = 1;
                    break;
            }
            move.put(a, b);
        }



        solve(1,1,0);
    }

    public static void solve(int x, int y, int time){
//        System.out.println(y + " " + x + " time: " + time);
//        System.out.println(" ");
//        for(int i = 1; i<MAP.length; i++){
//            for(int j = 1; j<MAP.length; j++){
//                System.out.print(MAP[i][j] +" ");
//            }
//            System.out.println(" ");
//        }
//        System.out.println("---------------");

        // 방향 설정
        if(move.containsKey(time)){
            dir = (dir + move.get(time)) % 4;
            if(dir < 0)
                dir = 3;
        }
        root.push(dir);
        // 이동할 좌표
        int next_x = x + dx[dir];
        int next_y = y + dy[dir];

        // 맵을 나가거나 내 몸인 경우
        if(next_x < 1 || next_x > N || next_y < 1 || next_y > N || MAP[next_y][next_x] == 1){
            System.out.println(time+1);
            return;
        }

        // 내가 이동할 좌표가 사과가 아니다. 그러면 한칸 이동하고 꼬리만 제거
        if(MAP[next_y][next_x] == 0){
            Stack<Integer> tmp = new Stack<>();
            tmp.addAll(root);
            dfs(next_x, next_y, 0, tmp);

            // 이동 완료
            MAP[next_y][next_x] = 1;
            solve(next_x,next_y, time+1);
        }

        else if(MAP[next_y][next_x] == -1){
            MAP[next_y][next_x] = 1;
            length++;
            solve(next_x,next_y, time+1);
        }
    }

    public static void dfs(int x, int y, int cnt, Stack<Integer> moved){

        while(cnt < length){
            int k = moved.pop();
//            System.out.println(k);
            x -= dx[k];
            y -= dy[k];
            cnt++;
        }
        MAP[y][x] = 0;



        // 꼬리를 0 처리.
//        if(cnt == length){
//            MAP[y][x] = 0;
//            return;
//        }
//
//        visited[y][x] = true;
//
//        for(int i = 0; i<4; i++){
//            int next_x = x + dx[i];
//            int next_y = y + dy[i];
//
//            if(next_x <0 || next_x > N || next_y < 0 || next_y > N)
//                continue;
//
//            if(MAP[next_y][next_x] == 1 && !visited[next_y][next_x])
//                dfs(next_x, next_y, cnt+1);
//            }
    }


}
