import java.io.*;
class brandiQ1 {
    static int[] flower_price = new int[3]; // R, G, B ¼ø¼­
    static String flower;
    static int result_price = Integer.MAX_VALUE, result_cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < tmp.length; i++)
            flower_price[i] = Integer.parseInt(tmp[i]);

        flower = br.readLine().trim();
        solve();
        System.out.println(result_price + " " + result_cnt);

    }

    public static void solve(){
        for(int i = 0; i < 6; i++){
            int cnt = 0;
            int price = 0;

            if(i == 0){ // R G
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'R'){
                            cnt++;
                            price = price + flower_price[0];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'G'){
                            cnt++;
                            price = price + flower_price[1];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'R'){
                        cnt++;
                        price = price + Math.min(flower_price[1], flower_price[2]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'G'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[2]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }

            else if(i == 1){// R B
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'R'){
                            cnt++;
                            price = price + flower_price[0];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'B'){
                            cnt++;
                            price = price + flower_price[2];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'R'){
                        cnt++;
                        price = price + Math.min(flower_price[1], flower_price[2]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'B'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[1]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }
            else if (i == 2){// G R
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'G'){
                            cnt++;
                            price = price + flower_price[1];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'R'){
                            cnt++;
                            price = price + flower_price[0];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'G'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[2]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'R'){
                        cnt++;
                        price = price + Math.min(flower_price[1], flower_price[2]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }
            else if (i == 3){// G B
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'G'){
                            cnt++;
                            price = price + flower_price[1];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'B'){
                            cnt++;
                            price = price + flower_price[2];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'G'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[2]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'B'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[1]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }

            else if (i == 4){// B R
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'B'){
                            cnt++;
                            price = price + flower_price[2];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'R'){
                            cnt++;
                            price = price + flower_price[0];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'B'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[1]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'R'){
                        cnt++;
                        price = price + Math.min(flower_price[1], flower_price[2]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }
            else{// B G
                for(int j = 0; j < flower.length()-1; j++){
                    if(j % 2 == 0){
                        if(flower.charAt(j) != 'B'){
                            cnt++;
                            price = price + flower_price[2];
                        }
                    }
                    else {
                        if(flower.charAt(j) != 'G'){
                            cnt++;
                            price = price + flower_price[1];
                        }
                    }
                }

                if(flower.length() % 2 == 0){
                    if(flower.charAt(flower.length()-1) == 'B'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[1]);
                    }
                }
                else{
                    if(flower.charAt(flower.length()-1) == 'G'){
                        cnt++;
                        price = price + Math.min(flower_price[0], flower_price[2]);
                    }
                }

                if(price == result_price){
                    result_cnt = Math.min(cnt, result_cnt);
                }
                if(price < result_price){
                    result_price = price;
                    result_cnt = cnt;
                }

            }




        }



    }
}