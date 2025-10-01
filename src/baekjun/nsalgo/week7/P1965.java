package baekjun.nsalgo.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}

/*
상자가 가장 많이 들어가는 경우를 찾기
앞에서부터 하나씩 선택해서 상자가 가장 많이 들어가는 경우를 찾아야 함
배열의 0번 인덱스부터 n-1번 인덱스까지 상자 존재
결국 배열에서 오름차순 찾기!!
 */