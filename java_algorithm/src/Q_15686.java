import java.io.*;
import java.util.ArrayList;

public class Q_15686 {
    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<point> chicken = new ArrayList<>();
    static ArrayList<point> home = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int p = Integer.parseInt(tmp[j]);
                if(p == 2) chicken.add(new point(j, i));
                else if(p == 1) home.add(new point(j, i));
            }
        }
        check = new boolean[chicken.size()];
        permutation(0, 0);
        System.out.println(answer);
    }

    public static void permutation(int idx, int s){
        if(s == M){
            solve();
            return;
        }
        for(int i = idx; i < check.length; i++){
            if(!check[i]){
                check[i] = true;
                permutation(i + 1, s + 1);
                check[i] = false;
            }
        }
    }

    public static void solve(){
        int sum = 0;
        for(int i = 0; i < home.size(); i++){
            int tmp = Integer.MAX_VALUE;
            for(int j = 0; j < chicken.size(); j++){
                if(check[j]) {
                    tmp = Math.min(tmp, Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y));
                }
            }
            sum += tmp;
        }

        answer = Math.min(sum, answer);
    }

}
