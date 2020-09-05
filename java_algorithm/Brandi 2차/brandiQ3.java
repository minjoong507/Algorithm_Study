import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class brandiQ3 {
    static int N, k;
    static int a, b;
    static int[] steal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        steal = new int[N+1];

        input = br.readLine().split(" ");
        for(int i = 1; i < N+1; i++)
            steal[i] = Integer.parseInt(input[i-1]);

        for(int i = 0; i < k; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            System.out.println(solve());
        }
    }

    public static int solve(){
        int[] tmp = new int[b - a + 1];
        for(int i = 0; i < tmp.length; i++)
            tmp[i] = steal[i + a];

        Arrays.sort(tmp);
//        for(int t: tmp)
//            System.out.print(t + " ");
//        System.out.println(" ");

        int cnt = 1;
        int prev = tmp[0];
        int result = prev;
        for(int i = 1; i < tmp.length; i++){
            if(tmp[i] == prev)
                cnt++;
            else
                cnt = 1;

            prev = tmp[i];
            result = result + tmp[i] * cnt;
        }

        return result;
    }
}