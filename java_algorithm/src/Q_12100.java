import java.io.*;
import java.util.*;

public class Q_12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] board;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int cnt){
        if(cnt == 5){
            for (int[] ints : board) {
                for (int j = 0; j < ints.length; j++) {
                    result = Math.max(result, ints[j]);
                }
            }
            return;
        }

        int[][] before_board = new int[N][N];
        copy(before_board, board);

        for(int i = 0; i<4; i++){

            // 왼쪽
            if(i == 0){
                for(int row = 0; row < N; row++){
                    for(int j = 0; j<N; j++){
                        for(int k = j+1; k<N; k++){
                            if(board[row][j] == 0){
                                board[row][j] = board[row][k];
                                board[row][k] = 0;
                            }

                            if(board[row][k] == 0) continue;
                            if(board[row][j] != board[row][k]) break;

                            board[row][j] += board[row][k];
                            board[row][k] = 0;

                        }
                    }


                }
                dfs(cnt+1);
                copy(board, before_board);
            }

            // 오른쪽
            else if (i == 1){
                for(int row = 0; row < N; row++){
                    for(int j = N-1; j>=0; j--){

                        for(int k = j-1; k>0; k--){
                            if(board[row][j] == 0){
                                board[row][j] = board[row][k];
                                board[row][k] = 0;
                            }


                            if(board[row][k] == 0) continue;
                            if(board[row][j] != board[row][k]) break;

                            if(board[row][j] == board[row][k]){
                                board[row][j] += board[row][k];
                                board[row][k] = 0;
                                break;
                            }
                        }
                    }


                }
                dfs(cnt+1);
                copy(board, before_board);

            }

            // 위
            else if (i == 2){
                for(int col = 0; col < N; col++){
                    for(int j = 0; j<N; j++){
                        for(int k = j+1; k<N; k++){

                            if(board[j][col] == 0){
                                board[j][col] = board[k][col];
                                board[k][col] = 0;
                            }


                            if(board[k][col] == 0) continue;
                            if(board[j][col] != board[k][col]) break;

                            if(board[j][col] == board[k][col]){
                                board[j][col] = board[j][col] * 2;
                                board[k][col] = 0;
                                break;
                            }
                        }
                    }
                }
                dfs(cnt+1);
                copy(board, before_board);
            }

            // 아래
            else {
                for(int col = 0; col < N; col++){
                    for(int j = N-1; j>=0; j--){
                        for(int k = j-1; k>0; k--){
                            if(board[j][col] == 0){
                                board[j][col] = board[k][col];
                                board[k][col] = 0;
                            }


                            if(board[k][col] == 0) continue;
                            if(board[j][col] != board[k][col]) break;

                            if(board[j][col] == board[k][col]){
                                board[j][col] = board[j][col] * 2;
                                board[k][col] = 0;
                                break;
                            }

                        }
                    }
                }
                dfs(cnt+1);
                copy(board, before_board);
            }
        }
    }

    public static void copy(int[][] arr, int[][] arr2) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = arr2[i][j];
            }
        }

    }


}
