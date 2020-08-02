import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class player{
    int idx, cnt;
    boolean isLeft;

    player(int idx, int cnt, boolean isLeft){
        this.idx = idx;
        this.cnt = cnt;
        this.isLeft = isLeft;
    }
}


public class Q_15558 {
    static Scanner sc = new Scanner(System.in);
    static int N, K;
    static int[] map1, map2;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited1, visited2;
    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();

        map1 = new int[N+1];
        map2 = new int[N+1];
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];
        visited1[0] = true;
        visited2[0] = true;

        String tmp = sc.next();
        for(int i = 1; i < N+1; i++) {
            map1[i] = tmp.charAt(i-1) - '0';
        }

        String tmp2 = sc.next();
        for(int j = 1; j < N+1; j++) {
            map2[j] = tmp2.charAt(j-1) - '0';
        }

        solve();

        if (result == 1) System.out.println("1");
        else System.out.println("0");
    }

    public static void solve(){
        Deque<player> q = new ArrayDeque<>();
        q.offer(new player(1,0,true));

        while(!q.isEmpty()){
            player p = q.poll();

            if(p.isLeft){
                visited1[p.idx] = true;

                for(int i = 0; i<3; i++){
                    if(p.idx + 1 >= N || p.idx + K >= N){
                        result = 1;
                        return;
                    }

                    if(i == 0 && p.idx + 1 <= N && map1[p.idx + 1] == 1 && !visited1[p.idx + 1])
                        q.offer(new player(p.idx + 1, p.cnt + 1, true));

                    else if(i == 1 && p.idx > 0  && p.idx - 1 <= N && map1[p.idx - 1] == 1 && p.idx - 1 > p.cnt + 1 && !visited1[p.idx - 1])
                        q.offer(new player(p.idx - 1, p.cnt + 1, true));

                    else if(i == 2 && p.idx + K <= N && map2[p.idx + K] == 1 && !visited2[p.idx + K])
                        q.offer(new player(p.idx + K, p.cnt + 1, false));
                }
            }
            else{
                visited2[p.idx] = true;

                for(int i = 0; i<3; i++){
                    if(p.idx + 1 >= N || p.idx + K >= N){
                        result = 1;
                        return;
                    }

                    if(i == 0 && p.idx + 1 <= N && map2[p.idx + 1] == 1 && !visited2[p.idx + 1])
                        q.offer(new player(p.idx + 1, p.cnt + 1, false));

                    else if(i == 1 && p.idx > 0  && p.idx - 1 <= N && map2[p.idx - 1] == 1 && p.idx - 1 > p.cnt + 1 && !visited2[p.idx - 1])
                        q.offer(new player(p.idx - 1, p.cnt + 1, false));

                    else if(i == 2 && p.idx + K <= N && map1[p.idx + K] == 1 && !visited1[p.idx + K])
                        q.offer(new player(p.idx + K, p.cnt + 1, true));
                }
            }
        }
    }
}
