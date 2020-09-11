class Solution {
    static int[][] block;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int map_size = key.length * 2 + lock.length - 2;
        block = new int[map_size][map_size];

        for(int i = 0; i < lock.length; i++){
            for(int j = 0; j < lock.length; j++){
                block[i + key.length - 1][j + + key.length - 1] = lock[i][j];
            }
        }

        for(int i = 0; i < 4; i++){
            key = rotateArray(key);
            if(check(key, lock)){
                answer = true;
                break;
            }
        }
        return answer;
    }

    public static boolean check(int[][] key, int[][] lock){
        boolean result = false;

        for(int i = 0; i < key.length + lock.length - 1; i++){
            for(int j = 0; j < key.length + lock.length - 1; j++){
                int[][] tmp = copyarr(block);
                addkey(j, i, key);
                if(ispossible(key.length, lock.length)){
                    result = true;
                    break;
                }
                block = copyarr(tmp);
            }
        }

        return result;

    }

    public static void addkey(int x, int y, int[][]key){
        for(int i = 0; i < key.length; i++){
            for(int j  = 0; j < key.length; j++){
                block[i+y][j+x] += key[i][j];
            }
        }
    }

    public static boolean ispossible(int k, int l){
        boolean isok = true;
        for(int i = k - 1; i < k + l - 1; i++){
            for(int j  = k - 1; j < k + l - 1; j++){
                if(block[i][j] != 1){
                    isok = false;
                    break;
                }
            }
        }

        return isok;
    }


    public static int[][] rotateArray(int[][] A) { // 시계방향 돌리기
        int SIZE = A.length;
        int[][] R = new int[SIZE][SIZE];

        for(int i = 0 ; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                R[i][j] = A[SIZE - 1 - j][i];
            }
        }
        return R;
    }

    public static int[][] copyarr(int[][] A) { // 배열 복사
        int SIZE = A.length;
        int[][] R = new int[SIZE][SIZE];

        for(int i = 0 ; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                R[i][j] = A[i][j];
            }
        }
        return R;
    }
}