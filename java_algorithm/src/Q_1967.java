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
    static int N;
    static ArrayList<ArrayList<node>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i< N+1; i++)
            tree.add(new ArrayList<node>());

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(a).add(new node(b, c));
            tree.get(b).add(new node(a, c));

        }
        int max_node = found_leafNode(1);
        BFS(max_node);
//        System.out.println(max_node);
    }

    public static int found_leafNode(int start) {
        Deque<node> q = new ArrayDeque<>();
        q.add(new node(start, 0));
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        int result = 0;
        int max_idx = 1;

        while (!q.isEmpty()) {
            node n = q.poll();

            for (node next : tree.get(n.idx)) {
                if (!visited[next.idx]) {
                    visited[next.idx] = true;
                    q.offer(new node(next.idx, n.weight + next.weight));
                }

                else{
                    if (result < n.weight) {
                        result = n.weight;
                        max_idx = n.idx;
                    }
                }
            }
        }

        return max_idx;
    }


    public static void BFS(int start) {
        Deque<node> q = new ArrayDeque<>();
        q.add(new node(start, 0));
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        int result = 0;
        while (!q.isEmpty()) {
            node n = q.poll();

            for (node next : tree.get(n.idx)) {
                if (!visited[next.idx]) {
                    visited[next.idx] = true;
                    q.offer(new node(next.idx, n.weight + next.weight));
                }
                else{
                    result = Math.max(result, n.weight);
                }
            }
        }
        System.out.println(result);
    }


}
