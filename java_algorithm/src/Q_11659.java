import java.io.*;
import java.util.StringTokenizer;

public class Q_11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringTokenizer st;
    static int[] arr;

    public static void main(String args[]) throws Exception{
        st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine().trim());

        for(int i = 1; i< N+1; i++)
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());


        for(int k = 0; k<M; k++){
            st = new StringTokenizer(br.readLine().trim());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(arr[j] - arr[i-1]);
        }
    }
}
