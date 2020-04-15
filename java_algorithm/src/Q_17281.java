import java.util.Scanner;

public class Q_17281 {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[][] score;
    static boolean[] visited = new boolean[10];
    static int[] player_list = new int[10];
    static int result = 0;

    public static void main(String args[]){
        N = sc.nextInt();
        score = new int[N][10];
        for(int i = 0; i<score.length; i++){
            for(int j = 1; j<10; j++){
                score[i][j] = sc.nextInt();
            }
        }
        for(int j = 1; j<10; j++){
            visited[j] = false;
        }
        sc.close();

        player_list[4] = 1;
        perm(1);
        System.out.println(result);

    }

    public static void perm(int idx){
        if(idx == 10){
            result = Math.max(playgame(), result);
//            System.out.println(" ");
//
//            for(int j = 1; j<10; j++){
//                System.out.print(player_list[j] + " ");
//            }
//            System.out.println(" ");
//            System.exit(0);
            return;
        }

        if(idx == 4){
            perm(idx+1);
            return;
        }

        for(int i = 2; i<10; i++){
            if(!visited[i]){
                visited[i] = true;
                player_list[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }

        }

    }

    public static int playgame() {
        int tot_score = 0;
        int now_round = 0;
        int next_player = 1;

        while (now_round < N) {
            boolean[] map = {false, false, false, false};
            int now_out = 0;
            int now_player = next_player;
            while (now_out < 3) {
                if(now_player==10)
                    now_player = 1;

                int tmp = player_list[now_player];
                switch (score[now_round][tmp]) {
                    case 0:
                        now_out++;
                        break;
                    case 1:
                        for(int i = 3; i>0; i--){
                            if(map[i]){
                                if(i == 3){
                                    tot_score++;
                                    map[i] = false;
                                }
                                else{
                                    map[i+1] = true;
                                    map[i] = false;
                                }
                            }
                        }
                        map[1] = true;
                        break;
                    case 2:
                        for(int i = 3; i>0; i--){
                            if(map[i]){
                                if(i == 1){
                                    map[i+2] = true;
                                    map[i] = false;
                                }
                                else{
                                    map[i] = false;
                                    tot_score++;
                                }
                            }
                        }
                        map[2] = true;
                        break;
                    case 3:
                        for(int i = 3; i>0; i--){
                            if(map[i]) {
                                tot_score++;
                                map[i] = false;
                            }
                        }
                        map[3] = true;
                        break;
                    case 4:
                        for(int i = 3; i>0; i--) {
                            if (map[i]) {
                                tot_score++;
                                map[i] = false;
                            }
                        }
                        tot_score++;
                        break;
                }
                now_player ++;
            }
            next_player = now_player;
            now_round++;
        }
        return tot_score;
    }
}
