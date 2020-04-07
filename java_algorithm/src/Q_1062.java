import java.io.*;
import java.util.ArrayList;

public class Q_1062 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int result = 0;
    static String[] word;
    static ArrayList<Character> whatilearn = new ArrayList<Character>();
    static ArrayList<Character> havetolearn = new ArrayList<Character>();

    public static void main(String args[]) throws Exception {

        String[] KN = br.readLine().split(" ");
        N = Integer.parseInt(KN[0]);
        K = Integer.parseInt(KN[1]);

        if (K<5){
            System.out.println(result);
            System.exit(0);
        }
        else if (K==26){
            System.out.println(N);
            System.exit(0);
        }
        K -= 5;
        word = new String[N];
        for(int i = 0;i <N; i++) {
            word[i] = br.readLine().replaceAll("[antic]", "");
            char[] tmp = word[i].toCharArray();
            for(int j=0; j<tmp.length; j++){
                if (!havetolearn.contains(tmp[j]))
                    havetolearn.add(tmp[j]);
            }
        }
//        for(int i = 0 ; i<havetolearn.size(); i++){
//            System.out.print(havetolearn.get(i));
//        }
//        System.out.println(havetolearn.size());
        solve(whatilearn, 0);
        System.out.println(result);

    }

    public static void solve(ArrayList<Character> arr, int depth){
        if (arr.size() == K){
//            for(int i = 0 ; i<arr.size(); i++){
//                System.out.print(arr.get(i));
//            }
//            System.out.println(" ");
            result = Math.max(result, checkword(arr));
            return;
        }
        if (arr.size() < K && depth < havetolearn.size()-1){
            arr.add(havetolearn.get(depth));
//            for(int i = 0 ; i<arr.size(); i++){
//                System.out.println(arr.get(i));
//            }
            solve(arr, depth +1);
            arr.remove(havetolearn.get(depth));

            solve(arr, depth+1);
        }

    }

    public static int checkword(ArrayList<Character> arr){
        int val = 0;
        for(int i = 0; i<word.length; i++) {
            boolean canlearn = true;

            for (int j = 0; j < word[i].length(); j++) {
                if (!arr.contains(word[i].charAt(j))) {
                    canlearn = false;
                    break;
                }
            }
            if (canlearn)
                val++;
        }
        return val;
    }


}
