import java.io.*;
import java.util.StringTokenizer;

public class Q_11437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] parent, depth, cond1, cond2;
    static int a,b;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception{
        N = Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        depth = new int[N+1];
        parent[1] = 1;
        depth[1] = 1;

        for(int i = 2; i<parent.length; i++){
            st = new StringTokenizer(br.readLine().trim());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(depth[a] != 0 && parent[a] != 0){
                parent[b] = a;
                depth[b] = depth[a] + 1;
            }
            else{
                parent[a] = b;
                depth[a] = depth[b] + 1;
            }
        }

        M = Integer.parseInt(br.readLine());
        cond1 = new int[M+1];
        cond2 = new int[M+1];

        for(int i = 1; i<M+1; i++){
            st = new StringTokenizer(br.readLine().trim());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int a_depth = depth[a];
            int b_depth = depth[b];

            while(a_depth > b_depth){
                a = parent[a];
                a_depth--;
            }
            while(a_depth < b_depth){
                b = parent[b];
                b_depth--;
            }
            while(a != b){
                a = parent[a];
                b = parent[b];
            }
            sb.append(a);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
