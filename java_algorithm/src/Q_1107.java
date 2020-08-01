import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayDeque;

class channel_info{
    int now_channel;
    int cnt;

    channel_info(int x, int y){
        this.now_channel = x;
        this.cnt = y;
    }
}

public class Q_1107 {
    static Scanner sc = new Scanner(System.in);
    static int channel;
    static ArrayList<Integer> broken_button = new ArrayList<>();
    static int result;
    public static void main(String[] args){
        channel = sc.nextInt();
        int N = sc.nextInt();
        for(int i = 0; i< N ; i++)
            broken_button.add(sc.nextInt());

        result = Math.abs(100 - channel);
        solve();
        System.out.println(result);
    }

    public static void solve(){
        ArrayDeque<channel_info> q = new ArrayDeque<>();
        q.offer(new channel_info(0, 0));

        while(!q.isEmpty()){
            channel_info tmp = q.poll();

            if(tmp.cnt > 6)
                return;

            if(tmp.cnt == 0){
                for(int i = 0; i< 10 ; i++){
                    if(!broken_button.contains(i))
                        q.offer(new channel_info(i, tmp.cnt + 1));
                }
            }
            else{
                result = Math.min(result, Math.abs(tmp.now_channel - channel) + tmp.cnt);
                for(int i = 0; i< 10 ; i++){
                    if(!broken_button.contains(i))
                        q.offer(new channel_info(tmp.now_channel * 10 + i, tmp.cnt + 1));
                }
            }





        }
    }


}
