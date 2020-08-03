import java.util.Scanner;

public class Q_10974 {
    static Scanner sc= new Scanner(System.in);
    static int N;
    public static void main(String[] args){
        N = sc.nextInt();

        permutation(new int[N+1], new boolean[N+1], 0);
    }

    public static void permutation(int[] arr, boolean[] visited,int depth){
        if(depth == N){
            printarray(arr);
            return;
        }

        for(int i = 1; i< N+1; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth+1] = i;
                permutation(arr, visited, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void printarray(int[] arr){
        for(int i =1; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
