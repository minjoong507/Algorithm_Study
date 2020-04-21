import java.util.*;

public class Q_1525 {
    static Scanner sc = new Scanner(System.in);
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};


    public static void main(String args[]){
        int start = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int k = sc.nextInt();
                if(k == 0)
                    k = 9;

                start = (start*10) +k;
            }
        }

        bfs(start);

    }

    public static void bfs(int num){

        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        m.put(num,0);
        q.add(num);

        while(!q.isEmpty()){
            int now = q.poll();
            String now_string = String.valueOf(now);
            int tmp = now_string.indexOf("9");

            int x = tmp % 3;
            int y = tmp / 3;

            for(int i = 0; i<4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x >= 0 && next_x < 3 && next_y >= 0 && next_y < 3){
                    int move = next_x + 3 * next_y;
                    StringBuilder sb = new StringBuilder(now_string);

                    char swap = sb.charAt(move);
                    sb.setCharAt(move, '9');
                    sb.setCharAt(tmp,swap);

                    int next_num = Integer.parseInt(sb.toString());
                    if(!m.containsKey(next_num)){
                        m.put(next_num, m.get(now) + 1);
                        q.add(next_num);
                    }
                }
            }
        }
        if (m.containsKey(123456789))
            System.out.println(m.get(123456789));

        else
            System.out.println("-1");

    }
}
