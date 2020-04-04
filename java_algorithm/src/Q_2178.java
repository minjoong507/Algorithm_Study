import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178 {
	static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    static int N,M;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
    	bfs(0,0);
    }

	public static void bfs(int x_start, int y_start) throws Exception{
		Queue<int[]> deque = new LinkedList<int[]>();
		Queue<Integer> distance = new LinkedList<Integer>();

		int[] start = {x_start, y_start};
		visited[x_start][y_start] = true;
		deque.add(start);
		distance.add(1);
		
		
		while (!deque.isEmpty()) {
			int[] node = deque.poll();
			int now_distance = distance.poll();
			int x = node[0];
			int y = node[1];
			
			if (x == N-1 && y == M-1 && visited[x][y]) {
				System.out.println(now_distance);
				break;
			}
			
			
			for (int i =0;i<4;i++) {
				int next_x = x + dr[i];
				int next_y = y + dc[i];
				
				 if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= M) {
	                    continue;
	                }
				 
				if (map[next_x][next_y] == 1 && visited[next_x][next_y] == false) {
					int[] next = {next_x, next_y};
					deque.add(next);
					distance.add(now_distance + 1);
					visited[next_x][next_y] = true;
				}
			}
		
		}
	}
}
