import java.util.Scanner;

public class Q_11726 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr;

    public static void main(String args[]){
        N = sc.nextInt();
        arr = new int[N+1];

        for(int i = 0; i< N + 1; i++){
            if(i<=2) arr[i] = i;

            else
                arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[N]);



    }




}
