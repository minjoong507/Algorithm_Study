import java.util.Scanner;

public class Q_15989 {
    static Scanner sc = new Scanner(System.in);
    static int Max_val = 10001;
    static boolean[][][] visited;
    static int target, result;
    public static void main(String[] args){
        int T = sc.nextInt();
        for(int i = 0; i< T; i++){
            target = sc.nextInt();
            result  = 0;
            visited = new boolean[Max_val][Max_val][Max_val];
            int[] arr = new int[4];
            solve(arr, 0);
            System.out.println(result);
        }

    }
    public static void solve(int[] num, int sum){
        if(sum == target && !visited[num[1]][num[2]][num[3]]){
            result++;
        }
        else if(sum < target) {
            for(int i = 1; i <=3; i++){
                num[i] += 1;
                solve(num, sum+i);
            }
        }

    }

}
