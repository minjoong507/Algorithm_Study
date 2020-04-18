import java.util.Scanner;

public class Q_2884 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        int A = sc.nextInt();
        int B = sc.nextInt();

        if (B>=45){
            B = B - 45;
            System.out.println(A + " " + B);
        }
        else{
            B = B + 15;
            if (A == 0)
                A = 23;
            else
                A--;

            System.out.println(A + " " + B);
        }
        sc.close();

    }

}
