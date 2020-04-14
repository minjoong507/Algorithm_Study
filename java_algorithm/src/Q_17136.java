import java.util.Scanner;

public class Q_17136 {
    static Scanner sc = new Scanner(System.in);
    static int N = 10;
    static int[][] arr = new int [10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String args[]){
        for(int i = 0; i <N; i++){
            for(int j = 0; j < N ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        solve(0,0);
        System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
    }

    public static void solve(int idx, int cnt){
        if(idx == 100){
            ans = Math.min(ans, cnt);
            return;
        }
        if (ans <= cnt)
            return;

        int x = idx % 10;
        int y = idx / 10;
//        System.out.println(x + " " + y);

        if(arr[y][x] == 1){
            for(int i = 5; i>0; i--){
                if(paper[i] > 0) {
                    if (check(x, y, i)) {
                        fillmap(x, y, i, 0);
                        paper[i]--;
                        solve(idx + 1, cnt + 1);
                        fillmap(x, y, i, 1);
                        paper[i]++;
                    }

                }

            }

        }
        else
            solve(idx+1,cnt);

    }

    public static boolean check(int x, int y, int size){
        if (x+size > 10 || y+size > 10)
            return false;

        for(int i = y; i<y+size; i++){
            for(int j = x; j<x+size;j++){
                if(arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void fillmap(int x, int y, int size, int val){
        for(int i = y; i<y+size; i++){
            for(int j = x; j<x+size;j++){
                arr[i][j] = val;
            }
        }
    }
}
