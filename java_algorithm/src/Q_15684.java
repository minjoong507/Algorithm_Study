import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q_15684 {

    static int N,M,H;
    static int[][] map;
    static int max;
    static boolean ok;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H+2][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for (int i = 0; i <= 3; i++) {
            max = i;
            solve(1,1,0);
            if(ok) break;
        }

        System.out.println(ok? max : -1);
    }

    static void solve(int x, int y, int cnt) {
        if(ok) return ;

        if(max == cnt) {
            if(check()) {
                ok = true;
            }
            return ;
        }

        for (int i = (y < N ? x : x+1); i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j] == 1 || map[i][j-1] == 1 || map[i][j+1] == 1) continue;
                map[i][j] = 1;
                solve(i,j,cnt+1);
                map[i][j] = 0;
            }
        }

    }

    static boolean check() {
        for (int j = 1; j <= N; j++) {
            int i = 1;
            int temp = j;
            while( i <= H+1) {

                if(map[i][temp] == 1) {
                    temp++;
                }
                else if(map[i][temp-1] == 1) {
                    temp--;
                }
                i++;
            }
            if(j != temp) {
                return false;
            }
        }
        return true;
    }

}
