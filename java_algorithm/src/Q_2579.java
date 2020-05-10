import java.util.*;

public class Q_2579 {
    static Scanner sc = new Scanner(System.in);
    static int K;
    static int[][] arr;
    public static void main(String[] args){
        K = sc.nextInt();

        if(K==1)
            System.out.println(sc.nextInt());
        else if(K==2){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);

        }
        else{
            arr = new int[3][K+1];

            for(int i = 1; i< K+1; i++)
                arr[0][i] = sc.nextInt();

            arr[1][1] = arr[0][1];
            arr[2][2] = arr[0][2];
            arr[1][2] = arr[1][1] + arr[0][2];

            for(int i = 3; i<K+1; i++){
                for(int step = 1; step<3; step++){
                    if(step == 1)
                        arr[step][i] = arr[0][i] + arr[2][i-1];
                    else
                        arr[step][i] = arr[0][i] + Math.max(arr[1][i-2],arr[2][i-2]);
                }
            }

            System.out.println(Math.max(arr[1][K], arr[2][K]));
        }


    }


}
