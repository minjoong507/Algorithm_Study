import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Collections;

class bottle{
    int a;
    int b;
    int c;

    bottle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Q_2251 {
    static boolean[][][] visited = new boolean[201][201][201];
    static ArrayList<Integer> result = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int A,B,C;
    public static void main(String args[]){
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        solve(A,B,C);
        Collections.sort(result);
        for(int val : result)
            System.out.print(val + " ");
    }

    public static void solve(int a, int b, int c){
        Deque<bottle> q = new ArrayDeque<>();
        q.offer(new bottle(0,0,c));

        while(!q.isEmpty()){
            bottle cur_bottle = q.poll();

            if (visited[cur_bottle.a][cur_bottle.b][cur_bottle.c])
                continue;


            visited[cur_bottle.a][cur_bottle.b][cur_bottle.c] = true;

            if (cur_bottle.a == 0 && !result.contains(cur_bottle.c))
                result.add(cur_bottle.c);

            // 6가지 경우 체크
            //1. a->b
            if(cur_bottle.a + cur_bottle.b > B)
                q.offer(new bottle(cur_bottle.a + cur_bottle.b - B, B, cur_bottle.c));
            else
                q.offer(new bottle(0, cur_bottle.a + cur_bottle.b, cur_bottle.c));

            //2. a->c
            if(cur_bottle.a + cur_bottle.c > C)
                q.offer(new bottle(cur_bottle.a + cur_bottle.c - C, cur_bottle.b, C));
            else
                q.offer(new bottle(0, cur_bottle.b, cur_bottle.a + cur_bottle.c));

            //3. b->a
            if(cur_bottle.b + cur_bottle.a > A)
                q.offer(new bottle(A, cur_bottle.b + cur_bottle.a - A, cur_bottle.c));
            else
                q.offer(new bottle(cur_bottle.a + cur_bottle.b, 0, cur_bottle.c));

            //4. b->c
            if(cur_bottle.b + cur_bottle.c > C)
                q.offer(new bottle(cur_bottle.a, cur_bottle.b + cur_bottle.c - C, C));
            else
                q.offer(new bottle(cur_bottle.a, 0, cur_bottle.b + cur_bottle.c));

            //5. c->a
            if(cur_bottle.c + cur_bottle.a > A)
                q.offer(new bottle(A, cur_bottle.b, cur_bottle.c + cur_bottle.a - A));
            else
                q.offer(new bottle(cur_bottle.a + cur_bottle.c, cur_bottle.b, 0));

            //6. c->b
            if(cur_bottle.c + cur_bottle.b > B)
                q.offer(new bottle(cur_bottle.a, B, cur_bottle.c + cur_bottle.b - B));
            else
                q.offer(new bottle(cur_bottle.a, cur_bottle.b + cur_bottle.c, 0));
        }

    }

}
