import java.util.ArrayList;
import java.util.Scanner;

public class Q_5567 {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static ArrayList<ArrayList<Integer>> friends;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args){
        N = sc.nextInt();
        M = sc.nextInt();
        friends = new ArrayList<>();

        for(int i = 0; i< N+1; i++)
            friends.add(new ArrayList<Integer>());

        for(int i = 0; i< M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        DFS(1, 0);
        System.out.println(result.size());

    }

    public static void DFS(int idx, int cnt){
//        System.out.println("idx :" + idx + " cnt :" + cnt);
        if(cnt == 2) return;

        if(cnt < 2){
            for(int friend: friends.get(idx)){
                if(friend == 1) continue;
                if (!result.contains(friend)){
                    result.add(friend);
                }
                DFS(friend, cnt + 1);
            }


        }


    }


}
