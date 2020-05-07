import java.util.ArrayList;

public class practice {
    public static void main(String args[]){
        int num = 2089;
        for(int i = 1; i< 100; i++){
            if(num % i == 0)
                System.out.println(i);
        }
        System.out.println();
    }

    public static int f(int i){
        return 1 + (58 * i);
    }
}
