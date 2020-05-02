import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_11438 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M;
    static int[][] parent;
    static int[] depth;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N+1; i++){
            arr.add(new ArrayList<>());
        }
        parent = new int[N+1][20];
        depth = new int[N+1];

        for(int i = 0 ; i< N-1; i++){
            st = new StringTokenizer(br.readLine().trim());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        maketree(1);
        // 여기까지 트리만들기



        M = Integer.parseInt(br.readLine());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine().trim());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(depth[L] > depth[R]){
                int tmp = R;
                R = L;
                L = tmp;
            }
            // R이 더 깊은거

            for(int d = 19; d >= 0; d--){
                if(Math.pow(2,d) <= depth[R] -depth[L])
                    R = parent[R][d];

            }
            if (L == R){
                sb.append(L);
            }
            else{
                for(int t=19; 0<=t; t--) {
                    if(parent[L][t] != parent[R][t]) {
                        L = parent[L][t];
                        R = parent[R][t];
                    }
                }
                sb.append(parent[L][0]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void maketree(int root){
        depth[root] = 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int node: arr.get(cur)){
                if(depth[node] > 0) continue;

                parent[node][0] = cur;
                depth[node] = depth[cur]+1;

                q.offer(node);
            }
        }

        for(int ln = 1; ln<20; ln++){
            for(int n = 1; n<N+1; n++){
                parent[n][ln] = parent[parent[n][ln-1]][ln-1];
            }
        }

    }


}


