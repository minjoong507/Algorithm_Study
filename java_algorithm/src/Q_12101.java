import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Q_12101 {

    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args){
        n = sc.nextInt();
        k = sc.nextInt();

        solve(new StringBuilder(), 0);

        if (result.size() < k)
            System.out.println("-1");
        else {
            Arrays.sort(result.toArray());
//            for(String tmp: result)
//                System.out.print(tmp + " ");
//            System.out.println("");
            System.out.println(result.get(k-1));
        }

    }

    public static void solve(StringBuilder sb, int sum){
        if (sum == n){
            result.add(sb.toString());
            return;
        }

        if (sum < n){
            for(int i = 1; i<= 3; i++){
                StringBuilder next_sb = new StringBuilder(sb);
                if (sum != 0){
                    next_sb.append("+");
                }
                solve(next_sb.append(i), sum + i);
            }
        }
    }

}
