import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w,h;
    static int[] dx = {-1, 0, 0, 1, 1, -1, -1, 1};
    static int[] dy = {0,-1, 1, 0, 1, 1, -1, -1};
    static int result;

    public static void main(String args[]) throws Exception {
        while (true){
            st = new StringTokenizer(br.readLine().trim());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;

            solve(w,h);
            System.out.println(result);
        }

    }

    public static void solve(int w, int h) throws Exception {
        int[][] arr = new int[h][w];
        result = 0;
        for(int i = 0; i< h; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j<w; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
                System.out.print(arr[i][j]);
            }
        }

        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                if(arr[i][j] == 1){
                    System.out.println(i + " " + j);
                    result ++;
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.offer(j);
                    q.offer(i);
                        while(!q.isEmpty()){
                            int x = q.poll();
                            int y = q.poll();
                            for(int t = 0; t<dx.length; t++){
                                int next_x = x + dx[t];
                                int next_y = y + dy[t];
                                if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h){
                                    q.add(next_x);
                                    q.add(next_y);
                                    arr[next_y][next_x] = 0;
                                }
                            }
                        }
                }
            }
        }


    }


}
