public static int solution(int A){
        String s = String.valueOf(A);
        StringBuilder sb = new StringBuilder();

        if(s.length() % 2 ==0){
            for(int i = 0; i <= s.length() / 2 - 1; i++){
                sb.append(s.charAt(i)).append(s.charAt(s.length() - 1 - i));
            }
        }
        else{
            for(int i = 0; i < s.length() / 2; i++){
                sb.append(s.charAt(i)).append(s.charAt(s.length() - 1 - i));
            }
            sb.append(s.charAt(s.length() / 2));
        }

        return Integer.parseInt(sb.toString());
    }