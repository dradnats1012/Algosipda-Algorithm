package baekjun.nsalgo.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = 0;
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];

        for (int j = 0; j < n; j++) {
            if (j == 2)
                dp[j] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
            if (j >= 3)
                dp[j] = Math.max(dp[j - 2] + arr[j], dp[j - 3] + arr[j - 1] + arr[j]);
        }

        System.out.println(dp[n - 1]);
    }
}
