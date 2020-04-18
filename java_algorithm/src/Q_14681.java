import java.util.Scanner;

public class Q_14681 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        int A = sc.nextInt();
        int B = sc.nextInt();

        if(A>0 && B>0)
            System.out.println(1);
        else if(A>0 && B<0)
            System.out.println(4);
        else if(A<0 && B<0)
            System.out.println(3);
        else
            System.out.println(2);
        sc.close();

    }

}
