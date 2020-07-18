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

        solve(100, 0, 0);
        System.out.println(result);
    }

    public static void solve(int now_channel, int cnt, int att){
        if (now_channel == channel){
            result = Math.min(result, cnt);
            return;
        }
        if (now_channel > 500000)
            return;

        if (now_channel < 0) now_channel = 0;

        if (now_channel < channel){
            if (att == 1) solve(now_channel + 1, cnt + 1,1);

            if (cnt == 0){
                for(int i = 1; i < 10; i++){
                    if(broken_button.contains(i))
                        continue;
                    solve(i, cnt + 1, 0);
                }
                solve(now_channel + 1, cnt + 1, 1);
            }
            else{
                for(int i = 0; i < 10; i++){
                    if(broken_button.contains(i))
                        continue;
                    solve(now_channel* 10 + i, cnt + 1, 0);
                }
                solve(now_channel + 1, cnt + 1, 1);
            }
        }

        else
            solve(now_channel - 1, cnt + 1, 1);
    }


}
