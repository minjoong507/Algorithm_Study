import java.util.ArrayList;
import java.util.Scanner;

public class Q_6603 {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    static int K;
    static boolean[] visited;
    static ArrayList<Integer> lotto;
    static StringBuilder sb;

    public static void main(String args[]){
        while (true){
            K = sc.nextInt();
            if(K == 0)
                break;

            arr = new int[K];
            sb = new StringBuilder();

            for(int i = 0; i<K; i++)
                arr[i] = sc.nextInt();

            for(int i = 0; i<=K-6; i++)
                dfs(i, 1, arr[i] + " ");


            System.out.println(sb);
        }
    }

    public static void dfs(int s, int cnt, String str){
        if(cnt == 6) {
            sb.append(str + "\n");
            return;
        }

        for(int i = s+1; i<arr.length; i++)
            dfs(i,cnt+1, str + arr[i] + " ");

    }

}
