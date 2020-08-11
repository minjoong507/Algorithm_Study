import java.util.*;
import java.io.*;

public class Q_1967 {
    static class node{
        int idx, weight;
        node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, max_L, max_R, result = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] weight;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i< N+1; i++)
            tree.add(new ArrayList<>());

        weight = new int[N+1][N+1];

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            weight[a][b] = c;

        }
        solve();
    }


    public static void solve(){
        for(int i = 1; i < N+1; i++){
            if(tree.get(i).size() == 2) {
                int L = tree.get(i).get(0);
                int R = tree.get(i).get(1);

                max_L = BFS(new node(L, weight[i][L]));
                max_R = BFS(new node(R, weight[i][R]));

                result = Math.max(result, max_L + max_R);
            }
        }
        System.out.println(result);
    }

    public static int BFS(node start){
        Deque<node> q = new ArrayDeque<>();
        q.add(start);
        int result = 0;

        while(!q.isEmpty()){
            node n = q.poll();
            if(tree.get(n.idx).size() == 0){
                result = Math.max(result, n.weight);
            }

            else{
                for(int next: tree.get(n.idx)){
                    if(tree.get(next).size() == 0)
                        result = Math.max(result, n.weight + weight[n.idx][next]);

                    else
                        q.offer(new node(next, weight[n.idx][next] + n.weight));
                }
            }
        }

        return result;
    }


}
