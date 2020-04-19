import java.util.Scanner;

public class Q_14501 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] day, price;
    static int benefit = Integer.MIN_VALUE;

    public static void main(String args[]){
        N = sc.nextInt();
        day = new int[N+1];
        price = new int[N+1];
        for(int i = 1; i<N+1; i++){
            day[i] = sc.nextInt();
            price[i] = sc.nextInt();
        }

        solve(1,0);
        System.out.println(benefit);

    }

    public static void solve(int idx, int val){
        if(idx > N){
            benefit = Math.max(benefit, val);
            return;
        }

        if((N+1 - idx) - day[idx] >= 0)
            solve(idx+day[idx], val + price[idx]);

        solve(idx + 1, val);


    }

}
