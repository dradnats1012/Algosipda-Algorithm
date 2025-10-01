package baekjun.kakao.dp;

import java.io.*;
import java.util.*;

public class P11052 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] p;     // 가격 배열
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = new int[n + 1];
        dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = p[1];

        for(int j = 2; j <= n; j++){
            dp[j] = p[j];   // 바로 j개 사버림
            for(int k = 1; k <= j; k++){
                dp[j] = Math.max(dp[j], dp[j - k] + p[k]);      // 돌면서 비교
            }
        }
        System.out.println(dp[n]);
    }
}


/*

 */