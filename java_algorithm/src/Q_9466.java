import java.util.ArrayList;
import java.util.Scanner;

public class Q_9466 {
    static Scanner sc = new Scanner(System.in);
    static int T, N, start, result;
    static boolean ok, cycle;
    static boolean[] checked;
    static int[] team;
    static ArrayList<Integer> member;

    public static void main(String[] args){
        T = sc.nextInt();
        for(int i = 0; i < T; i++){
            N = sc.nextInt();
            team = new int[N+1];
            checked = new boolean[N+1];

            for(int j = 1; j < N+1; j++)
                team[j] = sc.nextInt();

            solve();
        }
    }

    public static void solve(){
        result = 0;
        for(int i = 1; i < N+1; i++){
            if(!checked[i]){
                checked[i] = true;
                start = i;
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                DFS(i, new ArrayList<Integer>(a));
//                System.out.println(i);
//                System.out.println(result);

            }
        }
        System.out.println(N - result);
    }

    public static void DFS(int x, ArrayList<Integer> member){
        if(team[x] == start){
            result += member.size();
        }

        else if(checked[team[x]] && member.contains(team[x])){
            result += member.size() - member.indexOf(team[x]);
        }
        else if(!checked[team[x]]){
            checked[team[x]] = true;
            member.add(team[x]);
            DFS(team[x], member);
        }

    }

}
