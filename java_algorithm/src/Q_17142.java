import java.io.*;
import java.util.*;

class Pos {
    int r, c;
    Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Q_17142 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    static int N, M;
    static int[][] map, tmap;
    static boolean[] selected;
    static List<Pos> virus = new ArrayList<>();
    static Deque<Pos> q = new ArrayDeque<>();
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 맵크기 선언
        map = new int[N][N];

        // 맵 설정
        boolean hasNoBlank = true;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                // 바이러스 위치 저장
                if (map[r][c] == 2) {
                    virus.add(new Pos(r, c));
                } else if(map[r][c] == 0){
                    hasNoBlank = false;
                }
            }
        }
        if(hasNoBlank){
            System.out.println(0);
            return;
        }

        selected = new boolean[virus.size()];
        perm(0, 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime -1);
    }

    public static void perm(int idx, int cnt) {
        if (idx >= virus.size() || cnt >= M) {
            if (cnt == M)   bfs();
            return;
        }
        selected[idx] = true;
        perm(idx + 1, cnt + 1);
        selected[idx] = false;
        perm(idx + 1, cnt);
    }

    public static void bfs() {
        tmap = new int[N][N];
        for (int i = 0; i < selected.length; i++) {
            Pos p = virus.get(i);
            if (selected[i]) {
                q.addLast(p);
                tmap[p.r][p.c] = 1;
            }
        }
        while (!q.isEmpty()) {
            Pos p = q.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (tmap[nr][nc] != 0 || map[nr][nc] == 1)  continue;
                tmap[nr][nc] = tmap[p.r][p.c] + 1;
                q.addLast(new Pos(nr, nc));
            }
        }
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 || map[i][j] == 2)   continue;
                if (tmap[i][j] == 0)    return;
                maxTime = Math.max(maxTime, tmap[i][j]);
            }
        }
        minTime = Math.min(minTime, maxTime);
    }
}