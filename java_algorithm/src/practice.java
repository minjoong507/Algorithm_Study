import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class practice {
    static int[] arr;
    static boolean[] visited = new boolean[5];
    static ArrayList<Integer> bag = new ArrayList<>();

    public static void main(String args[]){
        arr = new int[]{1, 2, 3, 4, 5};

        dfs(0);

        int[] arr = new int[0];
        System.out.println(arr);

    }
    public static void dfs(int start){
        if(bag.size() == 3){
            Deque<Integer> q = new ArrayDeque<>(bag);

            for(int idx : bag){
                System.out.print(idx + " ");
            }
            System.out.println(" ");

            while(!q.isEmpty())
                System.out.println(q.poll());
            return;
        }

        for(int i = start; i< arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                bag.add(arr[i]);
                dfs(start);
                bag.remove(bag.size()-1);
            }
        }
    }

}
