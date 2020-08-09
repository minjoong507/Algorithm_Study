import java.util.ArrayList;
import java.util.Scanner;

public class Q_10159 {
    static Scanner sc =new Scanner(System.in);
    static int T, M, tmp;
    static int[] cnt;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> object;

    public static void main(String[] args){
        T = sc.nextInt();
        M = sc.nextInt();
        object = new ArrayList<>();
        for(int i = 0; i<T+1; i++){
            object.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            object.get(d1).add(d2);
        }
        cnt = new int[T+1];

        for(int i = 1; i < T+1; i++) {
            cnt[i]++;
            tmp = 0;
            visited = new boolean[T+1];
            visited[i] = true;
            DFS(i);
            cnt[i] += tmp;
        }

        for(int j = 1; j<T+1; j++)
            System.out.println(T - cnt[j]);
    }

    public static void DFS(int idx){
        for(int next: object.get(idx)){
            if(!visited[next]){
                visited[next] = true;
                tmp ++;
                cnt[next]++;
                DFS(next);
            }
        }
    }
}
