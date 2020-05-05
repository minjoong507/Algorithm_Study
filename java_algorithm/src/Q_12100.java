import java.io.*;
import java.util.*;

public class Q_12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] board;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int cnt) {
        // 움직인 횟수 5번이면 검사하고 종료
        if (cnt == 5) {
            for (int[] ints : board) {
                for (int anInt : ints) {
                    result = Math.max(result, anInt);
                }
            }
            return;
        }

        int[][] before_board = new int[N][N];
        copy(before_board, board);

        for (int i = 0; i < 4; i++) {
            //왼쪽
            if (i == 0) {
                for (int row = 0; row < N; row++) {
                    for (int L = 0; L < N; L++) {
                        for (int R = L + 1; R < N; R++) {
                            // 0이면 자리를 바꿔주고 더하기 시작.
                            if (board[row][L] == 0 && board[row][R] != 0) {
                                board[row][L] = board[row][R];
                                board[row][R] = 0;
                                continue;
                            }
                            if (board[row][R] == 0) continue;
                            if (board[row][L] != board[row][R]) break;

                            board[row][L] += board[row][R];
                            board[row][R] = 0;
                            break;
                        }
                    }
                }
            }

            // 오른쪽
            else if (i == 1) {
                for (int row = 0; row < N; row++) {
                    for (int L = N - 1; L >= 0; L--) {
                        // 0이면 자리를 바꿔주고 더하기 시작.

                        for (int R = L - 1; R >= 0; R--) {
                            if (board[row][L] == 0 && board[row][R] != 0) {
                                board[row][L] = board[row][R];
                                board[row][R] = 0;
                                continue;
                            }
                            if (board[row][R] == 0) continue;
                            if (board[row][L] != board[row][R]) break;

                            board[row][L] += board[row][R];
                            board[row][R] = 0;
                            break;
                        }
                    }
                }
            }
            // 위
            else if (i == 2) {
                for (int col = 0; col < N; col++) {
                    for (int U = 0; U < N; U++) {
                        // 0이면 자리를 바꿔주고 더하기 시작.

                        for (int D = U + 1; D < N; D++) {
                            if (board[U][col] == 0 && board[D][col] != 0) {
                                board[U][col] = board[D][col];
                                board[D][col] = 0;
                                continue;
                            }
                            if (board[D][col] == 0) continue;
                            if (board[U][col] != board[D][col]) break;

                            board[U][col] += board[D][col];
                            board[D][col] = 0;
                            break;
                        }
                    }
                }
            }

            // 아래
            else {
                for (int col = 0; col < N; col++) {
                    for (int U = N - 1; U > 0; U--) {
                        // 0이면 자리를 바꿔주고 더하기 시작.

                        for (int D = U - 1; D >= 0; D--) {
                            if (board[U][col] == 0 && board[D][col] != 0) {
                                board[U][col] = board[D][col];
                                board[D][col] = 0;
                                continue;
                            }
                            if (board[D][col] == 0) continue;
                            if (board[U][col] != board[D][col]) break;

                            board[U][col] += board[D][col];
                            board[D][col] = 0;
                            break;
                        }
                    }


                }

            }

            dfs(cnt + 1);
            copy(board, before_board);
        }
    }


    public static void copy ( int[][] arr, int[][] arr2){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = arr2[i][j];
            }
        }

    }
}
