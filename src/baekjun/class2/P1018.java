package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int result = minTrial(i, j, arr);
                if (count > result) {
                    count = result;
                }
            }
        }

        System.out.println(count);
    }

    private static int minTrial(int startrow, int startcol, String[] chess) {
        String[] board = {"WBWBWBWB", "BWBWBWBW"};
        int whiteCount = 0;

        for (int i = 0; i < 8; i++) {
            int row = startrow + i;
            for (int j = 0; j < 8; j++) {
                int col = startcol + j;

                if (chess[row].charAt(col) != board[row % 2].charAt(j)) {
                    whiteCount++;
                }
            }
        }

        return Math.min(whiteCount, 64 - whiteCount);
    }
}
