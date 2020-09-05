import java.io.*;
import java.util.ArrayList;

class Main {
    static class node{
        int idx, weight, cnt;
        node(int idx, int weight, int cnt){
            this.idx = idx;
            this.weight = weight;
            this.cnt = cnt;
        }
    }

    static int N, M, result = Integer.MAX_VALUE;
    static boolean isLoop = false;
    static int[] weight_list;
    static ArrayList<ArrayList<node>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        weight_list = new int[N+1];
        for(int i = 0; i< N+1; i++) arr.add(new ArrayList<node>());



        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            arr.get(Integer.parseInt(input[0])).add(new node(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 0));
        }
        dfs(new node(1, 0, 0));

        if(isLoop || result == Integer.MAX_VALUE)
            System.out.println("bug");
        else
            System.out.println(result);
    }

    public static void dfs(node n){
        if(n.idx == N){
            result = Math.min(n.weight, result);
            return;
        }
        if(n.cnt > 200) {
            isLoop = true;
            return;
        }

        if(weight_list[n.idx] == 0 || weight_list[n.idx] > n.weight)
            weight_list[n.idx] = n.weight;
        else
            return;


        for(node next_n: arr.get(n.idx)){
            dfs(new node(next_n.idx, n.weight + next_n.weight, n.cnt + 1));
        }

    }
}