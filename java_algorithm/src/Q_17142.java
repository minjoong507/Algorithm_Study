import java.io.*;
import java.util.*;

class Q_17142{
    static int N,K;
    static int[][] arr, time;
    static boolean[][] visited;
    static boolean[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> virus = new ArrayList<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 맵크기 선언
        arr = new int[N][N];

        // 맵 설정
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 위치 저장
                if(arr[i][j] == 2){
                    virus.add(i*10 + j);
                }
            }
        }

        selected = new boolean[virus.size()];
        permutation(0,0);
        if(result == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result);

    }

    public static void permutation(int start, int cnt){
        if(cnt == K){
            BFS();
            if(checkmap()) {
                result = Math.min(result, checktime());
                if(checktime()== 3)
                    printtime();
            }
        }

        for(int i =start; i<selected.length; i++){
            if(!selected[i]){
                selected[i] = true;
                permutation(i, cnt+1);
                selected[i] = false;
            }
        }

    }

    public static void BFS(){
        Deque<Integer> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        time = new int[N][N];

        for(int i = 0; i<selected.length; i++){
            if(selected[i]){
                int v = virus.get(i);
                visited[v/10][v%10] = true;
                q.offer(v);
            }
        }

        for(int i = 0; i<N; i++){
            for(int j =0; j<N;j++){
                if(arr[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i =0; i<4; i++){
                int next_x = dx[i] + now % 10;
                int next_y = dy[i] + now / 10;
                if(next_x >= 0 && next_x < N && next_y >= 0 && next_y < N){
                    if(!visited[next_y][next_x]){
                        visited[next_y][next_x] = true;
                        if(arr[next_y][next_x] == 0){
                            time[next_y][next_x] = time[now/10][now%10] + 1;
                            q.offer(next_y*10 + next_x);
                        }
                        if(arr[next_y][next_x] == 2){
                            time[next_y][next_x] = time[now/10][now%10];
                            q.offer(next_y*10 + next_x);
                        }
                    }
                }
            }
        }
    }
    public static void printtime(){
        for(int i = 0; i<N; i++){
            for(int j =0; j<N;j++){
                System.out.print(time[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static boolean checkmap(){
        for(int i = 0; i<N; i++){
            for(int j =0; j<N;j++){
                if(!visited[i][j])
                    return false;
            }
        }
        return true;
    }

    public static int checktime(){
        int t = 0;
        for(int i = 0; i<N; i++){
            for(int j =0; j<N;j++){
                t = Math.max(t, time[i][j]);
            }
        }
        return t;
    }



}

