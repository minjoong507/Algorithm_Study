import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Deque;

class Info{
    int now;
    int cnt;

    Info(int now, int cnt){
        this.now = now;
        this.cnt = cnt;
    }
}

public class Q_12851 {
    static Scanner sc = new Scanner(System.in);
    static int N, K, next_now;
    static int MAX_val = 100001;
    static boolean[] visited = new boolean[MAX_val];
    static int time = Integer.MAX_VALUE, tot = 0;
    public static void main(String[] args){

        N = sc.nextInt();
        K = sc.nextInt();

        solve();
        System.out.println(time);
        System.out.println(tot);
    }

    public static void solve(){
        Deque<Info> deque = new ArrayDeque<>();
        deque.offer(new Info(N, 0));
        int[] arr = new int[3];

        while(!deque.isEmpty()){
            Info now_info = deque.poll();
            arr[0] = now_info.now + 1;
            arr[1] = now_info.now - 1;
            arr[2] = now_info.now * 2;
            visited[now_info.now] = true;

            if(now_info.now == K){
                if(time == now_info.cnt)
                    tot++;

                else if (time > now_info.cnt){
                    time = now_info.cnt;
                    tot = 1;
                }
            }

            for(int i = 0; i<3; i++){
                if(arr[i] >= 0 && arr[i] < MAX_val && !visited[arr[i]])
                    deque.offer(new Info(arr[i], now_info.cnt + 1));
            }
        }
    }
}
