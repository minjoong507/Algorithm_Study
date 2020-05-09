import java.io.*;
import java.util.StringTokenizer;

public class Q_11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+2][N+2];

        for(int i = 1; i<arr.length-1; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = N; j>0; j-- ){
                arr[i][j] = arr[i][j+1] + Integer.parseInt(tmp[j-1]);
            }
        }

//        for(int i = 0; i<arr.length; i++){
//            for(int j = 0; j<arr.length; j++ ){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println(" ");
//        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine().trim());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            for(int t = x1; t <= x2; t++) {
//                System.out.println(arr[t][x1]);
//                System.out.println(arr[t][x2 + 1]);
                sum += (arr[t][y1] - arr[t][y2 + 1]);
            }

            System.out.println(sum);
        }




    }
}
