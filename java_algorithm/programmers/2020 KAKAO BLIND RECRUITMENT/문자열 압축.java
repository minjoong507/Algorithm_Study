class Solution {
    static int sol = Integer.MAX_VALUE;

    public int solution(String s) {
        for(int i = 1; i <= s.length() / 2; i++)
            Stringzip(s, i);

        if (s.length() == 1)
            return 1;
        else
            return sol;
    }
    public static void Stringzip(String s, int size){
        int cnt = 1;
        int result = 0;
        String before = s.substring(0,size);
        for(int i = size; i <= s.length() - size; i+= size){
            String now = s.substring(i, i + size);
            boolean iszip = true;
            for(int j = 0; j < size; j++){
                if(before.charAt(j) != now.charAt(j)){
                    iszip = false;
                    break;
                }
            }
            if(iszip)
                cnt++;

            else{
                before = now;
                if(cnt != 1){
                    result += String.valueOf(cnt).length();
                    cnt = 1;
                }
                result += size;
            }
        }

        if(cnt != 1)
            result += size + String.valueOf(cnt).length();
        else
            result += size;

        result += s.length() % size;

        sol = Math.min(sol, result);

    }

}