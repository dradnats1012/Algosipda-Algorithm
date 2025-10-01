package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;

        int[] kids = new int[n];
        for (int i = 0; i < kids.length; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (kids[j] < kids[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = max < dp[i] ? dp[i] : max;
        }

        System.out.println(n - max);
    }
}

/*
    N명의 아이들
    1 ~ N  번호표
    목적지까지 번호순으로 일렬
    중간에 번호 순서 바뀜 -> 번호 순서 되돌림
    위치를 옮기는 아이들의 수를 최소로
    N명의 아이들이 임의의 순서로 줄을 서 있을때, 옮겨지는 아이의 최소 수

    7

    3
    7
    5
    2
    6
    1
    4
 */