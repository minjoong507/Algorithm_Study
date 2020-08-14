import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<String> result = new ArrayList<>();
    static int[] number, count;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        number = new int[N];
        count = new int[10001];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            number[i] = tmp;
            count[tmp]++;
        }

        Arrays.sort(number);

        for(int i = 0; i < N; i++){
            StringBuilder tmp = new StringBuilder();
            tmp.append(number[i]).append(" ");
            count[number[i]] --;
            DFS(tmp, 1);
            count[number[i]] ++;
        }
//        DFS(new StringBuilder(), 0);
        bw.flush();

    }

    public static void DFS(StringBuilder sb, int cnt) throws IOException {
        if(cnt == M){
            String tmp = sb.toString().trim();
            if(!result.contains(tmp)){
                result.add(tmp);
                bw.write(tmp);
                bw.newLine();
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(count[number[i]] > 0){
                StringBuilder s = new StringBuilder(sb);
                s.append(number[i]).append(" ");
                count[number[i]]--;
                DFS(s, cnt + 1);
                count[number[i]]++;
            }
        }
    }


}
