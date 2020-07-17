import java.util.Scanner;

public class Q_11727 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i < N+1; i++){
            if(i==1) arr[1] = 1;

            else if(i==2) arr[2] = 3;

            else arr[i] = (arr[i-1] + 2 * arr[i-2]) % 10007;
        }

        System.out.println(arr[N]);

    }
}
