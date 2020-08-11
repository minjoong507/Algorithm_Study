import java.util.ArrayList;
import java.util.Scanner;

public class Q_2644 {
    static Scanner sc = new Scanner(System.in);
    static int N, M, A, B, result = 0;
    static ArrayList<ArrayList<Integer>> family;
    static boolean[] visited;
    static boolean ok = false;

    public static void main(String[] args){
        N = sc.nextInt();

        family = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 0; i< N+1; i++)
            family.add(new ArrayList<>());

        A = sc.nextInt();
        B = sc.nextInt();
        M = sc.nextInt();

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            family.get(a).add(b);
            family.get(b).add(a);
        }

        visited[A] = true;
        DFS(A, 0);
        if(ok)
            System.out.println(result);
        else
            System.out.println(-1);
    }

    public static void DFS(int idx, int cnt){
        if(idx == B){
            result = cnt;
            ok = true;
            return;
        }

        for(int next: family.get(idx)){
            if(!visited[next]){
                visited[next] = true;
                DFS(next, cnt + 1);
            }
        }
    }

}
