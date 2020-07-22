import java.util.ArrayList;
import java.util.Scanner;

public class Q_1107 {
    static Scanner sc = new Scanner(System.in);
    static int channel;
    static ArrayList<Integer> broken_button = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args){
        channel = sc.nextInt();
        int N = sc.nextInt();
        for(int i = 0; i< N ; i++)
            broken_button.add(sc.nextInt());

        System.out.println(result);
    }

    public static void solve(int now_channel, int cnt){

    }


}
