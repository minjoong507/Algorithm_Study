import java.util.Scanner;
import java.util.ArrayList;

public class Q_1707 {
    static ArrayList<ArrayList<Integer>> tree;
    static int K, V, E;
    static int[] color;
    static Scanner sc = new Scanner(System.in);
    static boolean ispossible;

    public static void main(String[] args){
        K = sc.nextInt();
        for(int i = 0; i < K; i++){
            V = sc.nextInt();
            E = sc.nextInt();
            tree = new ArrayList<>();

            for(int j = 0; j < V + 1; j++)
                tree.add(new ArrayList<>());

            for(int k = 0; k < E; k++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                tree.get(a).add(b);
                tree.get(b).add(a);
            }

            color = new int[V+1];
            ispossible = true;

            for(int node = 1; node < V+1; node++){
                if(color[node] == 0){
                    color[node] = 1;
                    DFS(node);
                }
            }

            check_is_possible();

            if (ispossible)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static void DFS(int node){
        for(int next_node: tree.get(node)){
            if(color[next_node] == 0){
                color[next_node] = 3 - color[node];
                DFS(next_node);
            }
        }

    }

    public static void check_is_possible(){
        for(int i = 1; i< V+1; i++){
            for(int next_node: tree.get(i)){
                if(color[next_node] == color[i]){
                    ispossible = false;
                    return;
                }
            }
        }

    }
}
