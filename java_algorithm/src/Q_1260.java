import java.io.*;
import java.util.*;

public class Q_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, start;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb1, sb2;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i = 0; i< N+1; i++)
            tree.add(new ArrayList<Integer>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        for(int i = 0; i< N+1; i++)
            Collections.sort(tree.get(i));

        sb1 = new StringBuilder();
        sb2 = new StringBuilder();

        dfs(start);
        visited = new boolean[N+1];
        bfs(start);

        System.out.println(sb1);
        System.out.println(sb2);
    }

    public static void dfs(int s){
        sb1.append(s);
        sb1.append(" ");
        visited[s] = true;
        for(int next: tree.get(s)){
            if(!visited[next]){
                dfs(next);
            }

        }
    }

    public static void bfs(int s){
        Deque<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()){
            int now = q.poll();
            sb2.append(now);
            sb2.append(" ");

            for(int next: tree.get(now)){
                if(!visited[next]){
                    visited[next]= true;
                    q.offer(next);
                }
            }

        }
    }

}
