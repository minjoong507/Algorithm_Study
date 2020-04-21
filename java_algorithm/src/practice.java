
public class practice {
    public static void main(String args[]){
        int now = 8;
        String x = "123456789";
        StringBuilder sb = new StringBuilder(x);

        char swap = sb.charAt(4);
        sb.setCharAt(4, '9');
        sb.setCharAt(now,swap);
        System.out.println(sb.toString());


    }
}
