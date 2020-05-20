import java.io.*;
import java.util.*;

class Q_17141 {
    static int N, M;
    static int[][] arr, time_map;
    static boolean[][] trace;
    static ArrayList<Integer> virus = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> selected_virus;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 맵크기 선언
        arr = new int[51][51];
        time_map = new int[51][51];

        // 맵 설정
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 벽은 -1로 저장
                if(arr[i][j] == 1)
                    time_map[i][j] = -1;


                // 바이러스 위치 저장
                if (arr[i][j] == 2)
                    virus.add(i * 10 + j);

            }
        }
        // 바이러스 선택해서 돌리자
        for(int i = 0; i<virus.size(); i++){
            visited = new boolean[virus.size()];
            selected_virus = new ArrayList<>();
            dfs(i);
        }
        if (result != Integer.MAX_VALUE)
            System.out.println(result);
        else
            System.out.println("-1");
    }

    public static void dfs(int start){
        if(selected_virus.size() == M){
            int time = solve();
//            System.out.println(time);
            if(checkmap())
                result = Math.min(time, result);
            return;
        }

        for(int i = start; i< virus.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                int v = virus.get(i);
                selected_virus.add(v);
                dfs(start);
                if (!selected_virus.isEmpty())
                    selected_virus.remove(selected_virus.size()-1);
            }
        }
    }

    public static int solve(){
        Deque<Integer> q = new ArrayDeque<>(selected_virus);
        trace = new boolean[51][51];

        int[][] tmp = new int[51][51];
        copy_map(tmp, time_map);

        while(!q.isEmpty()){
            int now = q.poll();
            int x = now % 10;
            int y = now / 10;
            trace[y][x] = true;

            for(int i = 0; i<4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(1<= next_x && next_x <= N && 1 <= next_y && next_y <= N){
                    if(!trace[next_y][next_x] && time_map[next_y][next_x] == 0){
                        trace[next_y][next_x] = true;
                        time_map[next_y][next_x] = time_map[y][x] + 1;
                        q.offer(next_x + next_y * 10);
                    }
                }
            }
        }

        int val = 0;
        for(int i = 1; i<N+1;i++){
            for(int j = 1; j<N+1; j++){
                val = Math.max(val, time_map[i][j]);
            }
        }

        // 이전 상태로 되돌리기 그리고 걸린 시간 반환
        copy_map(time_map, tmp);

        return val;
    }

    public static boolean checkmap(){
        for(int i = 1; i<N+1; i++){
            for(int j =1; j<N+1;j++){
                if(!trace[i][j] && time_map[i][j] != -1)
                    return false;
            }
        }
        return true;
    }

    // arr1을 arr2로 만들기
    public static void copy_map(int[][] arr1, int[][] arr2){
        for(int i = 1; i<N+1; i++){
            for(int j =1; j<N+1; j++){
                arr1[i][j] = arr2[i][j];
            }
        }
    }
}