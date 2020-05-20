import java.io.*;
import java.util.*;

class point{
    int x;
    int y;

    point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Q_17141 {
    static int N, M;
    static int[][] arr;
    static ArrayList<point> virus = new ArrayList<>();
    static boolean[] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 맵크기 선언
        arr = new int[N][N];

        // 맵 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 위치 저장
                if (arr[i][j] == 2) {
                    virus.add(new point(j, i));
                    arr[i][j] = 0;
                }
                // 벽은 -1로 저장
                else if(arr[i][j] == 1) {
                    arr[i][j] = -1;
                    cnt++;
                }
            }
        }

        visited = new boolean[virus.size()];
        if (cnt + virus.size() == N * N)
            result = 0;
        else
            dfs(0,0);

        if (result != Integer.MAX_VALUE)
            System.out.println(result);
        else
            System.out.println("-1");
    }

    public static void dfs(int depth, int start){
        if(depth == M){
            int[][] tmp = new int[N][N];
            copy_map(tmp, arr);
            solve();
            copy_map(arr, tmp);
            return;
        }

        for(int i = start; i< virus.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, start +1);
                visited[i] = false;
            }
        }
    }

    public static void solve(){
        Deque<point> q = new ArrayDeque<>();
        for(int i = 0; i<virus.size(); i++){
            if(visited[i]) q.offer(virus.get(i));
        }

        boolean[][] trace = new boolean[N][N];
        while(!q.isEmpty()){
            point now = q.poll();
            trace[now.y][now.x] = true;

            for(int i = 0; i<4; i++){
                int next_x = now.x + dx[i];
                int next_y = now.y + dy[i];

                if(0 <= next_x && next_x < N && 0 <= next_y && next_y < N && !trace[next_y][next_x] && arr[next_y][next_x] != -1){
                    trace[next_y][next_x] = true;
                    arr[next_y][next_x] = arr[now.y][now.x] + 1;
                    q.offer(new point(next_x, next_y));
                }
            }
        }

        int val = 0;
        boolean Check_all = true;

        for(int i = 0; i<N;i++){
            for(int j = 0; j<N; j++){
                if (!trace[i][j] && arr[i][j] != -1){
                    Check_all = false;
                    break;
                }
                else
                    val = Math.max(val, arr[i][j]);
            }
        }

        if (Check_all)
            result = Math.min(val, result);
        else
            return;
    }

    // arr1을 arr2로 만들기
    public static void copy_map(int[][] arr1, int[][] arr2){
        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++)
                arr1[i][j] = arr2[i][j];
        }
    }

}