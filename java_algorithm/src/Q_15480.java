import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_15480 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, r, u, v;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] parent;
    static int[] depth;

    public static void main(String args[]) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i< N+1; i++)
            tree.add(new ArrayList<Integer>());

        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        Maketree(1);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            r = Integer.parseInt(st.nextToken());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            int r1 = lca(r,u);
            int r2 = lca(u,v);
            int r3 = lca(v,r);

            if(depth[r1] < depth[r2])
                r1 = r2;

            if(depth[r1] < depth[r3])
                r1 = r3;
            sb.append(r1);
            sb.append("\n");


        }
        System.out.println(sb);

    }
    public static void Maketree(int root){
        parent = new int[N+1][20];
        depth = new int[N+1];

        Deque<Integer> q = new ArrayDeque<>();
        parent[root][0] = root;
        depth[root] = 1;
        q.offer(root);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: tree.get(now)){
                if(depth[next] > 0) continue;

                parent[next][0] = now;
                depth[next] = depth[now] + 1;
                q.offer(next);
            }


        }

        for(int ln = 1; ln<20; ln++){
            for(int n = 1; n<N+1; n++){
                parent[n][ln] = parent[parent[n][ln-1]][ln-1];
            }
        }
    }

    public static int lca(int u, int v){
        if(depth[u] > depth[v]){
            int tmp = v;
            v = u;
            u = tmp;
        }
        for(int j = 19; j>=0; j--){
            if(Math.pow(2,j) <= depth[v] - depth[u])
                v = parent[v][j];
        }
        if (u == v)
            return u;
        else{
            for(int height = 19; height>=0; height--){
                if(parent[u][height] != parent[v][height]){
                    u = parent[u][height];
                    v = parent[v][height];
                }
            }
            return parent[u][0];
        }
    }
}
