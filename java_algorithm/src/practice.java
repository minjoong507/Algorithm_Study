import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class practice {

    static ArrayList<Integer> bag = new ArrayList<>();
    static int[] check = new int[6];
    static int[] mark = {0, 1};
    public static void main(String args[]){
        dfs(0);
    }

    public static void dfs(int cnt){
        if(cnt == 6){
            for(int i=0; i< check.length; i++){
                if(check[i] == 0){
                    System.out.print(i + " ");
                }
            }
            System.out.println("-------");
            return;
        }

        for(int k = 0; k < 2; k++){
            check[cnt] = mark[k];
            dfs(cnt + 1);
        }



    }


}
