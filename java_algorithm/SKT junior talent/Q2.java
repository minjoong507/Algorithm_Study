public static long solution(int[] A){
        long result = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < A.length; ++i){
            if(A[i] < 0) continue;
            long sum = 0;
            for(int j = i; j < A.length; j++){
                tmp = j;
                if(A[j] >=0)
                    sum += A[j];
                else
                    break;
                }
            i = tmp;
            result = Math.max(result, sum);
        }
        return result;
}