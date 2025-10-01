package baekjun.kakao.dp;

import java.io.*;
import java.util.*;

public class P2579 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] stairs;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n];
        dp = new int[n];

        for(int i = 0; i < n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
            dp[i] = 0;
        }

        if(n == 1){
            System.out.println(stairs[0]);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        for(int j = 0; j < n; j++){
            if(j == 2){
                dp[j] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
            } if(j >= 3){
                dp[j] = Math.max(dp[j - 2] + stairs[j], dp[j - 3] + stairs[j - 1] + stairs[j]);
            }
        }

        System.out.println(dp[n-1]);
    }
}


/*
계단 오르기
1. 한번에 한 계단씩 또는 두 계단씩 오를 수 있음
2. 연속된 세 개의 계단을 모두 밟으면 안됨
3. 마지막 도착 계단은 반드시 밟아야 함

이 게임에서 얻을 수 있는 총 점수의 최댓값

1번계단까지 최대
- 1번을 밟음

2번계단
- 1번과 2번을 밟음

3번계단
- 1, 3 vs 2, 3

4번계단
- 1, 2, 4 vs 1, 3, 4

5번계단
- 1, 2, 4, 5 vs 1, 3, 5 vs 2, 3, 5
   dp[2] + ar[4] + ar[5]     dp[3] + ar[5]
6번계단
- 1, 2, 4, 6 vs 1, 3, 4, 6 vs 2, 3, 5, 6
      dp[4] + ar[6]            dp[3] + ar[5] + ar[6]
7번계단
- 1, 2, 4, 5, 7 vs 1, 3, 4, 6, 7 vs 1, 3, 5, 7

8번계단
- 1, 2, 4, 5, 7, 8 vs 1, 2, 4, 6, 8 vs

 */