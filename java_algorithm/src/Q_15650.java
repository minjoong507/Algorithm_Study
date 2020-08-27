import java.util.ArrayList;
import java.util.Scanner;

public class Q_15650 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(i+1);
            DFS(arr);
        }
    }

    public static void DFS(ArrayList<Integer> arr){
        if(arr.size() == M){
            for(int tmp: arr){
                System.out.print(tmp + " ");
            }
            System.out.println("");
            return;
        }

        for(int i = arr.get(arr.size() - 1); i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(i+1);
                DFS(arr);
                arr.remove(arr.size() - 1);
                visited[i] = false;
            }
        }



    }


}
