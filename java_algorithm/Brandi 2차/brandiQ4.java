import java.io.*;
import java.util.ArrayList;

class brandiQ4 {
    static int N, M, a, b;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N+1; i++){
            arr.add(new ArrayList<>());
        }
        String[] tmp = br.readLine().split(" ");

        for(int i = 0; i< N; i++){
            a = Integer.parseInt(tmp[0]);
            b = Integer.parseInt(tmp[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        M = Integer.parseInt(br.readLine());



    }
}