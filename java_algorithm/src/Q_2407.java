import java.io.*;
import java.util.*;

class Data {
    static long LMAX = (long) 1e17;
    long front, back;

    public Data(long front, long back){
        this.front = front;
        this.back = back;
    }
    public Data add(Data o){
        long over = (this.back + o.back > LMAX) ? 1 : 0;
        return new Data(this.front+o.front+over,
                this.back+o.back-over*LMAX);
    }
}

class Solution_Q_2407{
    Scanner sc = new Scanner(System.in);
    final int MAXN = 100 + 2;

    Data[][] comb = new Data[MAXN][MAXN];

    public Solution_Q_2407(){
        comb[1][0] = new Data(0, 1);
        comb[1][1] = new Data(0, 1);

        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int n = 2; n <= N; n++) {
            for (int m = 0; m <= n; m++) {
                comb[n][m] = (n == m || m == 0) ?
                        new Data(0, 1) : comb[n-1][m-1].add(comb[n-1][m]);
            }
        }
        String ans = (comb[N][M].front > 0 ? comb[N][M].front+"" : "")+ comb[N][M].back;
        System.out.println(ans);
    }
}

public class Q_2407 {
    public static void main(String[] args) throws IOException {
        new Solution_Q_2407();
    }
}