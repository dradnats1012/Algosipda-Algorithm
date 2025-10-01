package baekjun.nsalgo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2688 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;

        dp = new long[65][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int j = 2; j <= 64; j++) {
            for (int k = 0; k <= 9; k++) {
                for (int l = k; l <= 9; l++) {
                    dp[j][k] += dp[j - 1][l];
                }
            }
        }

        for (int a = 0; a < t; a++) {
            n = Integer.parseInt(br.readLine());
            long answer = 0;

            for (int i = 0; i < 10; i++) {
                answer += dp[n][i];
            }

            System.out.println(answer);
        }
    }
}
