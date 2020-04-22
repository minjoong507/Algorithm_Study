import java.util.Scanner;

public class Q_1463 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr = new int[1000001];

    public static void main(String args[]){
        N = sc.nextInt();

        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for(int i = 4 ; i<arr.length; i++){
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0)
                arr[i] = Math.min(arr[i], arr[i /2] + 1);
            if(i % 3 == 0)
                arr[i] = Math.min(arr[i], arr[i /3] + 1);
        }

        System.out.println(arr[N]);


    }

}
