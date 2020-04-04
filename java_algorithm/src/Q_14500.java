//import java.io.*;
//import java.util.*;
//
//public class Q_14500 {
//	static int n;
//	static int m;
//	static int[][] map;
//
//	// 상하좌우 표현
//	static int[] dx = { 1, -1, 0, 0 };
//	static int[] dy = { 0, 0, 1, -1 };
//	static int max = 0;
//	static boolean[] visited;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		map = new int[n][m];
//		visited = new boolean[n * m];
//
//		for (int i = 0; i < n; i++) {
//			st = new StringTokenizer(reader.readLine());
//			for (int j = 0; j < m; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		for (int i = 0; i < n * m; i++) {
//			int r = i / m;
//			int c = i % m;
//			visited[i] = true;
//			dfs(i, map[r][c], 0, visited);
//			fuckU(i);
//			Arrays.fill(visited, false);
//		}
//		System.out.println(max);
//	}
//
//	private static void fuckU(int index) {
//		int r = index / m;
//		int c = index % m;
//
//		// ' ㅜ '
//		if (r + 1 < n && c + 2 < m)
//			max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);
//
//		// ' ㅗ '
//		if (r - 1 >= 0 && c + 2 < m)
//			max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
//
//		// ' ㅏ '
//		if (r + 2 < n && c + 1 < m)
//			max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);
//
//		// ' ㅓ '
//		if (r + 2 < n && c - 1 >= 0)
//			max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);
//
//		return;
//
//	}
//
//	public static void dfs(int index, int sum, int time, boolean[] visited) {
//		if (time == 3) {
//			max = Math.max(max, sum);
//			return;
//		}
//		int r = index / m;
//		int c = index % m;
//
//		for (int i = 0; i < 4; i++) {
//			if (r + dx[i] < n && r + dx[i] >= 0 && c + dy[i] < m && c + dy[i] >= 0) {
//				if (!visited[(r + dx[i]) * m + c + dy[i]]) {
//					dfs((r+dx[i])*m+c+dy[i], sum+map[r+dx[i]][c+dy[i]], time+1, visited);				}
//
//			}
//
//		}
//		visited[index] = false;
//	}
//}

import java.io.*;
import java.util.*;
 
public class Q_14500 {
    static int n;
    static int m;
    static int[][] a;
    static int[] tx = {1, -1, 0, 0};
    static int[] ty = {0, 0, 1, -1};
    static int max = 0;
    static boolean[] visited;
 
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        visited = new boolean[n*m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n*m; i++) {
            int r = i/m;
            int c = i%m;
            visited[i] = true;
            dfs(i, a[r][c], 0, visited);
            getException(i);
            Arrays.fill(visited, false);
        }
        System.out.println(max);
    }
 
    static void dfs(int idx, int sum, int cnt, boolean[] visited) {
        if(cnt==3) {
            max = Math.max(max, sum);
            return;
        }
        int r = idx/m;
        int c = idx%m;
        visited[idx] = true;
        for(int i=0; i<4; i++) {
            if(r+tx[i]>=0 && r+tx[i]<n && c+ty[i]>=0 && c+ty[i]<m) {
                if(!visited[(r+tx[i])*m+c+ty[i]]) {
                    dfs((r+tx[i])*m+c+ty[i], sum+a[r+tx[i]][c+ty[i]], cnt+1, visited);
                }
            }
        }
        visited[idx] = false;
    }
 
    static void getException(int idx) {
        int r = idx/m;
        int c= idx%m;
        int sum = a[r][c];
        int cnt = 0;
        for(int i=0; i<4; i++) {
            if(r+tx[i]>=0 && r+tx[i]<n && c+ty[i]>=0 && c+ty[i]<m) {
                sum+= a[r+tx[i]][c+ty[i]];
                cnt++;
            }
        }
        if(cnt<3 || sum < max) return;
        if(cnt==3) {
            max = Math.max(max, sum);
        } else {
            for(int i=0; i<4; i++) {
                max = Math.max(max, sum-a[r+tx[i]][c+ty[i]]);
            }
        }
    }
}
