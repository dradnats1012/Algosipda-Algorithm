package baekjun.kakao.dp;

import java.io.*;
import java.util.*;

public class P2133 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        if(n % 2 == 1){
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 0;
        if(n >= 2){
            dp[2] = 3;
        }

        for(int i = 3; i <= n; i++){
            int result = 0;
            if(i % 2 == 0){

                for(int k = 0; k < i - 3; k++){
                    if(k % 2 == 0){
                        result += dp[k] * 2;
                    }
                }
            }
            dp[i] = result + dp[i - 2] * 3;
        }
        System.out.println(dp[n]);
    }
}


/*
타일 채우기
n이 홀수면 0 반환 -> 타일을 다 채우지를 못함
n = 2 -> 3가지 이걸 기준으로 둬야할듯
n = 4 -> 3 X 3(dp[n - 2]) + 2 : 가운데 가로 블럭이 껴잇는 경우 2개를 더함
n = 6 -> 3 X 11 + 틈에 껴있는 경우

틈에 껴있는 경우를 어떻게 구하지
n - 4의 경우의 수 X 2인가

 */