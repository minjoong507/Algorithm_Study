import java.util.ArrayList;
import java.util.Scanner;

public class Q_17471 {
    static Scanner sc = new Scanner(System.in);
    static int N, result = Integer.MAX_VALUE;
    static int[] popular;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args){
        N = sc.nextInt();
        for(int i = 0 ; i < N + 1; i++)
            arr.add(new ArrayList<>());

        popular = new int[N+1];
        for(int i = 1; i<N+1; i++)
            popular[i] = sc.nextInt();

        for(int i = 1; i < N+1; i++){
            int connect_n = sc.nextInt();
            for(int j = 0; j < connect_n; j++){
                int node = sc.nextInt();
                arr.get(i).add(node);
            }
        }

    }

    public static void solve(){
//        for(int i = 1; i< N+1; i++){
//
//        }




    }

    // �̷��� �׷����� ���� �� �ִ��� üũ.
    public static boolean ispossiblegroup(ArrayList<Integer> group){
        return false;
    }

    // �̷��� �׷����� ������ �� �α� ����.
    public static void check_population(ArrayList<Integer> group){

    }

}
