import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Collections;

public class Q_2251 {
    static int volume;
    static ArrayList<Integer> result = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int[] method = new int[4];
    public static void main(String args[]){
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        method[0] = A;
        method[1] = -A;
        method[2] = B;
        method[3] = -B;

        solve(C);
        Collections.sort(result);
        for(int val : result) {
            if (val == 0)
                continue;

            System.out.print(val + " ");
        }
    }


    public static void solve(int c){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(c);

        while(!q.isEmpty()){
            volume = q.poll();
            result.add(volume);

            for(int i = 0; i<method.length; i++){
                int next = volume + method[i];
                if(next >= 0 && next <= c && !result.contains(next))
                    q.offer(next);
            }

        }

    }

}
