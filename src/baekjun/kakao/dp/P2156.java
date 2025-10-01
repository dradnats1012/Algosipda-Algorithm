package baekjun.kakao.dp;

import java.io.*;
import java.util.*;

public class P2156 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = 0;
        }

        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];

        if (n >= 3) {
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])
                );
            }
        }

        System.out.println(dp[n - 1]);
    }
}


/*
포도주 시식
1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다
2. 연속으로 놓여 있는 3잔을 모두 마실 수 는 없다
가장 많은 양의 포도주를 마실 수 있도록

dp[0] = arr[0]
dp[1] = arr[0] + arr[1]

dp[2]
- 0 + 1 vs 0 + 2 vs 1 + 2

dp[3]
- 0 + 1 + 3 vs 0 + 2 + 3 vs 1 + 2
(i - 2) + arr[3] vs (i - 3) + arr[i - 1] + arr[i] vs dp[i - 1]
 */