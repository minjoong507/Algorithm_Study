import java.io.*;
import java.util.StringTokenizer;

public class Q_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 1; i<= N; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" ");
            DFS(sb, 1, i);
        }

        bw.flush();

    }

    public static void DFS(StringBuilder sb, int cnt, int val) throws IOException {
        if(cnt == M){
            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for(int i = val; i <= N; i++){
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(i).append(" ");
            DFS(tmp, cnt + 1, i);
        }
    }


}
