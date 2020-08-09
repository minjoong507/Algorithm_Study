import java.util.ArrayList;
import java.util.Scanner;

public class Q_2606 {
    static Scanner sc = new Scanner(System.in);
    static int N, M, result = 0;
    static ArrayList<ArrayList<Integer>> network;
    static boolean[] visited;

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        network = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 0; i< N+1; i++)
            network.add(new ArrayList<>());

        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            network.get(a).add(b);
            network.get(b).add(a);
        }
        visited[1] = true;
        DFS(1);
        System.out.println(result);
    }

    public static void DFS(int idx){
        for(int next: network.get(idx)){
            if (next == 1) continue;

            if(!visited[next]){
                visited[next] = true;
                result++;
                DFS(next);
            }
        }

    }
}
