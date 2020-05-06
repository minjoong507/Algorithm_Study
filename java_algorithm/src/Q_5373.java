import java.io.*;
import java.util.*;

public class Q_5373 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, n;
    static String[] rotate;
    static char[][][] cube  = new char[6][3][3]; // U, D, F, B, L, R
    static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'};

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i< T; i++){
            n = Integer.parseInt(br.readLine());
            rotate = br.readLine().split(" ");
            set_cube();
            solve();
            draw();
        }



    }

    public static void solve(){
        for(int i = 0; i<rotate.length; i++){
            switch(rotate[i].charAt(0)){
                // U, D, F, B, L, R
                case 'F' :
                    if(rotate[i].charAt(1) == '+'){
                        rotation_F(1);
                        rotate_only(2, 1);
                    }
                    else{
                        rotation_F(3);
                        rotate_only(2, 3);
                    }
                    break;

                case 'B' :
                    if(rotate[i].charAt(1) == '+'){
                        rotation_B(3);
                        rotate_only(3, 1);
                    }
                    else{
                        rotation_B(1);
                        rotate_only(3, 3);
                    }
                    break;

                case 'R':
                    if(rotate[i].charAt(1) == '+'){
                        rotation_LR(2, 1);
                        rotate_only(5, 1);
                    }
                    else{
                        rotation_LR(2, 3);
                        rotate_only(5, 3);
                    }
                    break;

                case 'L':
                    if(rotate[i].charAt(1) == '+'){
                        rotation_LR(0, 3);
                        rotate_only(4, 1);
                    }
                    else{
                        rotation_LR(0, 1);
                        rotate_only(4, 3);
                    }
                    break;

                case 'U':
                    if(rotate[i].charAt(1) == '+'){
                        rotation_U(1);
                        rotate_only(0, 1);
                    }
                    else{
                        rotation_U(3);
                        rotate_only(0, 3);
                    }
                    break;

                case 'D':
                    if(rotate[i].charAt(1) == '+'){
                        rotation_D(3);
                        rotate_only(1, 1);
                    }
                    else{
                        rotation_D(1);
                        rotate_only(1, 3);
                    }
                    break;

            }
            draw();
            System.out.println("");
            System.out.println("앞");
            print_cube(2);
            System.out.println("뒤");
            print_cube(3);
            System.out.println("__");
        }

    }

    public static void set_cube(){
        for(int i = 0; i<cube.length; i++){
            for(int j =0; j<cube[i].length; j++){
                Arrays.fill(cube[i][j], color[i]);
            }
        }
    }

    public static void print_cube(int i){
        for(int j = 2; j>=0; j--){
            for(int k =0; k<3; k++){
                System.out.print(cube[i][j][k]);
            }
            System.out.println(" ");
        }
    }


    public static void rotation_F(int time) {
        int t = 0;

        while (t < time) {
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for (int i = 0; i < 3; i++) {
                move_N[i] = cube[0][2][i];
                move_E[i] = cube[5][i][0];
                move_S[i] = cube[1][0][i];
                move_W[i] = cube[4][i][2];
            }

            for (int i = 0; i < 3; i++) {
                cube[0][2][i] = move_W[i];
                cube[5][i][0] = move_N[i];
                cube[1][0][i] = move_E[i];
                cube[4][i][2] = move_S[i];
            }
            t++;
        }
    }

    public static void rotation_B(int time) {
        int t = 0;

        while(t < time){
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for(int i = 0; i<3; i++) {
                move_N[i] = cube[0][0][i];
                move_E[i] = cube[5][i][2];
                move_S[i] = cube[1][2][i];
                move_W[i] = cube[4][i][0];
            }

            for(int i = 0; i<3; i++) {
                cube[0][0][i] = move_W[i];
                cube[5][i][2] = move_N[i];
                cube[1][2][i] = move_E[i];
                cube[4][i][0] = move_S[i];
            }
            t++;
        }
    }




    public static void rotation_LR(int n, int time){
        // n은 R이면 2, L이면 0
        int t = 0;


        while(t < time){
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for(int i = 0; i<3; i++) {
                move_N[i] = cube[0][i][n];
                move_E[i] = cube[3][i][n];
                move_S[i] = cube[1][i][n];
                move_W[i] = cube[2][i][n];
            }

            for(int i = 0; i<3; i++) {
                cube[0][i][n] = move_W[i];
                cube[3][i][n] = move_N[i];
                cube[1][i][n] = move_E[i];
                cube[2][i][n] = move_S[i];
            }
            t++;
        }

    }

    public static void rotation_D(int time){
        int t = 0;


        while(t < time){
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for(int i = 0; i<3; i++) {
                move_N[i] = cube[2][0][i];
                move_E[i] = cube[4][0][i];
                move_S[i] = cube[3][2][i];
                move_W[i] = cube[5][0][i];
            }

            for(int i = 0; i<3; i++) {
                cube[2][0][i] = move_W[i];
                cube[4][0][i] = move_N[i];
                cube[3][2][i] = move_E[i];
                cube[5][0][i] = move_S[i];
            }
            t++;
        }

    }
    public static void rotation_U(int time){
        int t = 0;


        while(t < time){
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for(int i = 0; i<3; i++) {
                move_N[i] = cube[2][2][i];
                move_E[i] = cube[4][2][i];
                move_S[i] = cube[3][0][i];
                move_W[i] = cube[5][2][i];
            }

            for(int i = 0; i<3; i++) {
                cube[2][2][i] = move_W[i];
                cube[4][2][i] = move_N[i];
                cube[3][0][i] = move_E[i];
                cube[5][2][i] = move_S[i];
            }
            t++;
        }

    }

    public static void rotate_only(int front, int time){
        int t = 0;

        while(t < time){
            char[] move_N = new char[3];
            char[] move_E = new char[3];
            char[] move_S = new char[3];
            char[] move_W = new char[3];

            for(int i = 0; i<3; i++) {
                move_N[i] = cube[front][0][i];
                move_E[i] = cube[front][i][2];
                move_S[i] = cube[front][2][i];
                move_W[i] = cube[front][i][0];
            }

            for(int i = 0; i<3; i++) {
                cube[front][0][i] = move_W[i];
                cube[front][i][2] = move_N[i];
                cube[front][2][i] = move_E[i];
                cube[front][i][0] = move_S[i];
            }
            t++;
        }

    }

    public static void draw(){
        for(int j = 0; j<3; j++){
            for(int k =0; k<3; k++){
                System.out.print(cube[0][j][k]);
            }
            System.out.println(" ");
        }
    }

}
