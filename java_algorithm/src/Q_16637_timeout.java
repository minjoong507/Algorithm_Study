import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_16637_timeout {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long result = Long.MIN_VALUE;
    static int N;
    static char[] token;
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        token = br.readLine().toCharArray();
        System.out.println(solve(0, token[0]-'0'));
    }
    public static int solve(int idx, int cur){
        if(idx >= N-1){
            return cur;
        }
        // 괄호 연산 후 dfs
        int ret = solve(idx+2, calculate(cur, token[idx+2]-'0', token[idx+1]));

        // 괄호 연산 안하고 dfs
        if(idx+4 <= N-1){
            int val = calculate(cur,
                    calculate(token[idx+2]-'0', token[idx+4]-'0', token[idx+3]),
                    token[idx+1]);
            ret = Math.max(ret, solve(idx+4, val));
        }
        return ret;
    }


    public static int calculate(int a, int b, char opr){
        switch (opr){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return 0;
    }
}
