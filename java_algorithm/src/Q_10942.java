import java.io.*;
import java.util.*;

public class Q_10942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, S, E;
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args[]) throws Exception{
        N = Integer.parseInt(br.readLine());

        arr= new int[N+1];
        st = new StringTokenizer(br.readLine().trim());

        for(int i = 0; i<N+1; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine().trim());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
        }



    }



}
