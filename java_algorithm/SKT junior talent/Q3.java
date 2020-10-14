import java.util.ArrayList;
import java.util.Collections;

public class practice {
    public static void main(String args[]){
        System.out.println(solution("photo.jpg, Warsaw, 2013-09-05 14:08:15XX"));
    }

    public static String solution(String S) {
        ArrayList<String> city = new ArrayList<>();
        ArrayList<ArrayList<String>> time = new ArrayList<>();
        String[] tmp = S.split("XX");
        for(int i = 0; i < tmp.length; i++){
            String[] info = tmp[i].split(",");
            String city_n = info[1].trim();
            String time_n = info[2].trim();
            tmp[i] = info[0].trim().split("[.]")[1];
            boolean find = false;
            for(int j = 0; j < time.size(); j++){
                if(city_n.equals(city.get(j))){
                    time_n = time_n + " " + i;
                    time.get(j).add(time_n);
                    find = true;
                }
            }
            if(!find){
                city.add(city_n);
                time.add(new ArrayList<>());
                time_n = time_n + " " + i;
                time.get(time.size() - 1).add(time_n);
            }
        }
        for(int j = 0; j < city.size(); j++){
            Collections.sort(time.get(j));
            String city_n = city.get(j);
            String file_n = " ", extenstion = " ";
            int idx;
            for(int k = 0; k < time.get(j).size(); k++){
                idx = Integer.parseInt(time.get(j).get(k).split(" ")[2]);
                extenstion = tmp[idx];
                if(time.get(j).size() < 10){
                    file_n = city_n + String.valueOf(k+1) + "." + extenstion;
                    tmp[idx] = file_n;
                }
                else if(time.get(j).size() >= 10 && time.get(j).size() < 100){
                    if(k < 9)
                        file_n = city_n + "0" + String.valueOf(k+1) + "." + extenstion;
                    else
                        file_n = city_n + String.valueOf(k+1) + "." + extenstion;
                    tmp[idx] = file_n;
                }
                else{
                    if(k < 9)
                        file_n = city_n + "00" + String.valueOf(k+1) + "." + extenstion;
                    else if(k < 99)
                        file_n = city_n + "0" + String.valueOf(k+1) + "." + extenstion;
                    else
                        file_n = city_n + String.valueOf(k+1) + "." + extenstion;
                    tmp[idx] = file_n;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < tmp.length; t++){
            sb.append(tmp[t]).append("\n");
        }

        return sb.toString();
    }
}
