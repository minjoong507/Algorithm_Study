import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Q_13913 {
    static Scanner sc = new Scanner(System.in);
    static int N,K;
    static int[] time = new int[100001];
    static int[] before = new int[100001];

    public static void main(String args[]){
        N = sc.nextInt();
        K = sc.nextInt();
        bfs();

        Stack<Integer> result = new Stack<Integer>();
        result.push(K);

        while(N != K){
            K = before[K];
            result.push(K);
        }
        System.out.println(result.size()  -1);
        while(!result.empty())
            System.out.print(result.pop() + " ");
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        time[N] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K)
                return;

            for(int i = 0; i <3 ; i++){
                int next;

                if (i==0)
                    next = now + 1;
                else if(i==1)
                    next = now - 1;
                else
                    next = now * 2;

                if(next<0 || next > 100000)
                    continue;

                if(time[next] == 0){
                    time[next] = time[now] + 1;
                    before[next] = now;
                    q.add(next);
                }


            }
        }


    }
}
