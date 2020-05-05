import java.io.*;
import java.util.StringTokenizer;

public class Q_13458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, B, C;
    static int[] A;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine().trim());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i<A.length; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        solve();
    }

    public static void solve(){
        long result = 0;
        for(int i = 0; i<A.length; i++){
            int rest = A[i] - B;
            result++;

            if(rest>0){
                long q = rest / C;
                long r = rest % C;
                if(r == 0)
                    result += q;
                else
                    result += (q + 1);
            }
        }

        System.out.println(result);



    }
}
