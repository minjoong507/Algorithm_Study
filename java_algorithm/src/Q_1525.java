import java.util.*;

public class Q_1525 {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> q = new LinkedList<>();
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public static void main(String args[]){

        int start = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int k = sc.nextInt();
                if(k == 0) { //0À» 9·Î ¹Ù²Þ
                    k = 9;
                }
                start = (start*10) +k;
            }
        }



    }

    public static int solve(int num){

        
        return 0;
    }
}
