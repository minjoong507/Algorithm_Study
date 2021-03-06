import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] number;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        number = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            number[i] = tmp;
        }
        Arrays.sort(number);
//        for(int i = 0; i < N; i++){
//            StringBuilder tmp = new StringBuilder();
//            tmp.append(number[i]).append(" ");
//            DFS(tmp, 1, number[i]);
//
//        }
        DFS(new StringBuilder(), 0, 0);

        bw.flush();

    }

    public static void DFS(StringBuilder sb, int cnt, int num) throws IOException {
        if(cnt == M){
            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++){
            if(cnt == 0){
                StringBuilder s = new StringBuilder(sb);
                s.append(number[i]).append(" ");
//                visited[i] = true;
                DFS(s, cnt + 1, number[i]);
//                visited[i] = false;
            }
            else if(number[i] >= num){
                StringBuilder s = new StringBuilder(sb);
                s.append(number[i]).append(" ");
//                visited[i] = true;
                DFS(s, cnt + 1, number[i]);
//                visited[i] = false;
            }
        }
    }


}
