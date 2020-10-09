import java.util.ArrayList;
import java.util.Scanner;

public class Q_2210 {

    static ArrayList<String> result = new ArrayList<>();
    static int[][] map = new int[5][5];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                dfs(i, j, 0, "");
            }
        }

        System.out.println(result.size());
    }

    public static void dfs(int x, int y, int cnt, String s){
        if(cnt == 6){
            if(!result.contains(s))
                result.add(s);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                dfs(nx, ny, cnt + 1, s + map[ny][nx]);
            }
        }


    }
}

