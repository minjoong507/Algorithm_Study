import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Q_5014 {
    static Scanner sc = new Scanner(System.in);
    static int F, S, G, U, D;
    static int[] cnt;
    static int MAX = 1000001;

    public static void main(String[] args){
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        cnt = new int[MAX];
        bfs(S);

    }

    public static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        cnt[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == G){
                System.out.println(cnt[now]-1);
                return;
            }
            else{
                int up = now + U;
                int down = now - D;

                if(up<= F)
                    if(cnt[up] == 0) {
                        q.offer(up);
                        cnt[up] = cnt[now] + 1;
                    }
                if(now - D > 0)
                    if(cnt[down] == 0) {
                        q.offer(down);
                        cnt[down] = cnt[now] + 1;
                    }
            }
        }
        System.out.println("use the stairs");
    }
}
