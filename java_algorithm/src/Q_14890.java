import java.io.*;
import java.util.Queue;

public class Q_14890 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,L;
    static int[][] arr;
    static int result = 0;

    public static void main(String args[]) throws Exception{
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        arr = new int[N][N];

        for(int i = 0; i<arr.length; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j<arr[i].length; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i = 0; i<arr.length; i++){
            if (solve(i, 0, true))
                result++;

            if (solve(0, i, false))
                result++;
        }
        System.out.println(result);

    }

    public static boolean solve(int row, int col, boolean isright){
        boolean[] visited = new boolean[N];
        int[] heightmap = new int[N];
        if(isright) {
            for(int i = 0; i<N; i++){
                heightmap[i] = arr[row][i];
                visited[i] = false;
            }
        }
        else{
            for(int i = 0; i<N; i++){
                heightmap[i] = arr[i][col];
                visited[i] = false;
            }
        }

        for(int i = 0; i<N-1; i++){
            if(heightmap[i] == heightmap[i+1])
                continue;

            if (Math.abs(heightmap[i] - heightmap[i+1]) > 1) {
                return false;
            }


            if (heightmap[i] - 1 == heightmap[i+1]) {
                for (int j=i+1; j<=i+L; j++) {
                    if (j >= N || heightmap[i+1] != heightmap[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
            // 올라가야되는 경우
            else if (heightmap[i] + 1 == heightmap[i+1]) {
                for (int j=i; j>i-L; j--) {
                    if (j < 0 || heightmap[i] != heightmap[j] || visited[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            }
        }

        return true;

    }
}
