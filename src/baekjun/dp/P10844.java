package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844 {
    static int modifiedNum = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int DP[][] = new int[n + 1][11];
        int result = 0;

        for (int i = 1; i <= 9; i++) {  // 배열 초기화
            DP[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    DP[i][j] = DP[i - 1][1] % modifiedNum;
                else if (j == 9) {
                    DP[i][j] = DP[i - 1][8] % modifiedNum;
                } else
                    DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % modifiedNum;
            }
        }

        for (int i = 0; i <= 9; i++) {
            result = (result + DP[n][i]) % modifiedNum;
        }

        System.out.println(result);
    }
}
