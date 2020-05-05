import java.io.*;
import java.util.*;

public class Q_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int space = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static ArrayList<Integer> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j =0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    virus.add(i*10 + j);
                }
            }
        }

        dfs(0);
        System.out.println(space);
    }

    public static void dfs(int cnt){
        if(cnt == 3){
            int[][] tmp = new int[N][M];
            copy(tmp, arr);
            space = Math.max(Caculate_space(), space);

            copy(arr, tmp);
            return;
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    visited[i][j] = true;
                    arr[i][j] = 1;
                    dfs(cnt+1);

                    arr[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }


    }

    public static int Caculate_space(){
        int val = 0;
        for(int v: virus){
            int x = v % 10;
            int y = v / 10;
            spread_virus(x,y);
        }

        for(int i = 0; i<N; i++){
            for(int j =0; j<M; j++){
                if(arr[i][j] == 0)
                    val++;
            }
        }

        return val;
    }

    public static void spread_virus(int x, int y){
        for(int i = 0; i<4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N){
                if(arr[next_y][next_x] == 0){
                    arr[next_y][next_x] = 2;
                    spread_virus(next_x, next_y);
                }
            }
        }
    }



    public static void copy(int[][] arr1, int[][]arr2){
        for(int i = 0; i < arr2.length; i++){
            for(int j =0; j<arr2[i].length; j++){
                arr1[i][j] = arr2[i][j];
            }
        }
    }
}
