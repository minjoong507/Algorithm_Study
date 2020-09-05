import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int age, Max_heart;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] result = new int[6];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(br.readLine());
        String line;

        while ((line = br.readLine()) != null) {
            arr.add(Integer.parseInt(line));
        }
        br.close();
        Max_heart = 220 - age;

        solve();
        for(int r: result){
            System.out.print(r + " ");
        }
    }

    public static void solve(){
        for(int s: arr){
            s = s * 10;

            if(Max_heart * 6 > s) result[5]++;

            else if(Max_heart * 6.8 > s)result[4]++;

            else if(Max_heart * 7.5 > s) result[3]++;

            else if(Max_heart * 8 > s) result[2]++;

            else if(Max_heart * 9 > s) result[1]++;

            else result[0]++;

        }

    }
}