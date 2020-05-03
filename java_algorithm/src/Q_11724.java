import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M, u, v;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringTokenizer st;
    static boolean[] visited;
    public static void main(String args[]) throws Exception{
        int result = 0;
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i = 0; i<N+1; i++) {
            arr.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        for(int i = 1; i<M+1; i++){
            st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }
//        for(int i = 1; i<M+1; i++){
//            for(int j =0;j<arr.get(i).size(); j++){
//                System.out.print(arr.get(i).get(j));
//            }
//            System.out.println(" ");
//        }

        for(int j = 1; j<N+1; j++){
            if(!visited[j]){
                visited[j] = true;
                bfs(j);
                result++;
//                System.out.println(j);
            }
        }
        System.out.println(result);


    }

    public static void bfs(int r){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(r);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int connect: arr.get(now)){
                if(!visited[connect]){
                    q.offer(connect);
                    visited[connect] = true;
                }
            }
        }
    }



}
