import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class Q_15651 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        DFS(sb, 0);
        bw.flush();

    }

    public static void DFS(StringBuilder sb, int cnt) throws IOException {
        if(cnt == M){
            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++){
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(i+1).append(" ");
            DFS(tmp, cnt + 1);
        }
    }


}
