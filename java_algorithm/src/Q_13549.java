import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class subin{
    int idx, time;

    subin(int idx, int time){
        this.idx = idx;
        this.time = time;
    }

}

public class Q_13549 {
    static Scanner sc = new Scanner(System.in);
    static int N, K, diff;
    static boolean[] visited = new boolean[100001];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args){
        N = sc.nextInt();
        K = sc.nextInt();
        diff = Math.abs(N - K);

        BFS();
        System.out.println(result);
    }

    public static void BFS(){
        Deque<subin> q = new ArrayDeque<>();
        q.offer(new subin(N, 0));
        while(!q.isEmpty()){
            subin s = q.poll();
            visited[s.idx] = true;

            if(s.idx == K){
                result = Math.min(result, s.time);
                continue;
            }
            if(s.time > result)
                continue;

            for(int i = 0; i < 3; i++){
                if(i == 0 && bound(s.idx + 1) && !visited[s.idx + 1])
                    q.offer(new subin(s.idx +1, s.time + 1));

                else if(i == 1 && bound(s.idx - 1) && !visited[s.idx - 1])
                    q.offer(new subin(s.idx - 1, s.time + 1));

                else if(i == 2 && bound(s.idx * 2) && !visited[s.idx * 2] && s.idx * 2 - K <= diff)
                    q.offer(new subin(s.idx * 2, s.time));
            }
        }

    }

    public static boolean bound(int idx){
        if(idx < 0 || idx > 100000)
            return false;
        else
            return true;

    }

}
