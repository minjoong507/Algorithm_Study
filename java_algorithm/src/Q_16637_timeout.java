import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_16637_timeout {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long result = Long.MIN_VALUE;
    static int N;
    static String[] prob;


    public static void main(String args[]) throws Exception{
        N = Integer.parseInt(br.readLine());
        prob = br.readLine().split("");

        solve(prob);
        System.out.println(result);
    }

    public static void solve(String[] ary){
        if(ary.length == 1){
            result = Math.max(Integer.parseInt(ary[0]), result);
            return;
        }

        for(int i = 0; i< ary.length-1; i+=2)
            solve(Caculatearray(ary, i));
    }


    public static String[] Caculatearray(String[] ary, int point){
        ArrayList<String> arr = new ArrayList<>();
        String[] tmp = new String[ary.length-2];

        for(int i = 0; i<ary.length; i++){
            if(i == point) {
                int a = Integer.parseInt(ary[i]);
                String op = ary[i+1];
                int b = Integer.parseInt(ary[i+2]);

                switch (op){
                    case "+":
                        arr.add(String.valueOf(a+b));
                        break;
                    case "-":
                        arr.add(String.valueOf(a-b));
                        break;
                    case "*":
                        arr.add(String.valueOf(a*b));
                        break;
                }
                i = i + 2;
            }
            else
                arr.add(ary[i]);
        }

        int size = 0;
        for(String str: arr)
            tmp[size++] = str;

        return tmp;
    }


}
