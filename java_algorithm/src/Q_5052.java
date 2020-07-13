import java.io.*;
import java.util.Arrays;

public class Q_5052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n;
    static String[] number;
    static boolean answer;
    static StringBuilder result = new StringBuilder();

    public static void main(String args[]) throws Exception{
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());
            number = new String[n];

            for(int j = 0; j<n; j++)
                number[j] = br.readLine();
            answer = true;
            solve();

            if (answer) result.append("YES\n");
            else result.append("NO\n");
        }
        System.out.println(result.toString());

    }

    public static void solve(){
        Arrays.sort(number);
        for(int i = 0; i < number.length - 1; i++){
            int a = number[i].length();
            int b = number[i+1].length();

            if(a < b){
                if(number[i + 1].startsWith(number[i])){
                    answer = false;
                    break;
                }

            }
        }
    }
}
