import java.util.Scanner;

public class Q_1748 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int N = sc.nextInt();

        long result = 0;
        int i = 10;
        int cnt = 1;
        while (i<=N){
            result += cnt * 9 * Math.pow(10, cnt -1);
            i = i * 10;
            cnt ++;
        }

        result += (N - Math.pow(10, cnt-1) + 1) * cnt;
        System.out.println(result);



    }
}
