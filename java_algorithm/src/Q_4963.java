import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w,h;
    static int[] dx = {-1, 0, 0, 1, 1, -1, -1, 1};
    static int[] dy = {0,-1, 1, 0, 1, 1, -1, -1};
    static int result;
    static int[][] arr;

    public static void main(String args[]) throws Exception {
        while (true){
            st = new StringTokenizer(br.readLine().trim());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;

            arr = new int[h][w];
            result = 0;
            for(int i = 0; i< h; i++){
                String[] tmp = br.readLine().split(" ");
                for(int j = 0; j<w; j++){
                    arr[i][j] = Integer.parseInt(tmp[j]);
                }
            }

            bfs();
            System.out.println(result);
        }

    }

    public static void bfs(){
        Queue<Integer> qu = new ArrayDeque<>();

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                if(arr[i][j] == 1){
                    result++;
                    qu.offer(i*100 + j);

                    while(!qu.isEmpty()){
                        int node = qu.poll();
                        int x = node % 100;
                        int y = node / 100;

                        for(int k = 0; k<dx.length; k++){
                            int next_x = x + dx[k];
                            int next_y = y + dy[k];
                            if(next_x >= 0 && next_x < w && next_y>=0 && next_y < h &&arr[next_y][next_x] == 1){

                                qu.offer(next_y*100 + next_x);
                                arr[next_y][next_x] = 0;
                            }
                        }
                    }
                }
            }
        }




    }



}
