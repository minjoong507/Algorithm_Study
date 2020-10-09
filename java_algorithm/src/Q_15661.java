import java.io.*;

public class Q_15661 {
    static int N, M, result = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] S;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N / 2;
        S = new int[N][N];
        visited = new boolean[N];

        String[] tmp;
        for(int i = 0; i < N; i++){
            tmp  = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        permutation(0);
        System.out.println(result);
    }

    public static void permutation(int depth){
        if(depth == N){
            result = Math.min(result, StartandLink());
            return;
        }
        visited[depth] = true;
        permutation(depth + 1);
        visited[depth] = false;
        permutation(depth+1);
    }

    public static int StartandLink(){
        int start = 0;
        int link = 0;
        for(int i = 0; i < S.length; i++){
            for(int j = i+1; j < S[i].length; j++){
                if(visited[i] != visited[j])
                    continue;
                if(visited[i])
                    start += S[i][j] + S[j][i];
                else
                    link += S[i][j] + S[j][i];
            }
        }
        return Math.abs(start - link);
    }
}
