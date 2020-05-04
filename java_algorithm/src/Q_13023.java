import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();

    public static void main(String args[]) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        for(int i = 0; i<N; i++) {
            friends.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        for(int now = 0; now<N; now++) {
            visited[now]= true;
            dfs(now,1);
            visited[now]= false;
        }
        System.out.println(0);
    }

    public static void dfs(int now, int depth){
        if(depth==5){
            System.out.println("1");
            System.exit(0);
        }

        if(depth<5){
            for(int next: friends.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    dfs(next,depth+1);
                    visited[next] = false;
                }
            }
        }

    }

}
