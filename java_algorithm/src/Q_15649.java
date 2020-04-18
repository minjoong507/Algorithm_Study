import java.util.Scanner;

public class Q_15649 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static boolean[] visited;
    static int[] arr, result;
    public static void main(String args[]){

        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            arr[i] = i+1;
            visited[i] = false;
        }

        solve(0);




    }

    public static void solve(int depth){
        if (depth == M){
            for(int i = 0; i<M; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println("");
            return;
        }

        if (depth < N){
            for(int i = 0; i<visited.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    result[depth] = arr[i];
                    solve(depth+1);
                    visited[i] = false;
                }
            }

        }

        else
            return;

    }

}
