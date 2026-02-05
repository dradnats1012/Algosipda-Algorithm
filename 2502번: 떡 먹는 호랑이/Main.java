/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2502                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2502                           #+#        #+#      #+#    */
/*   Solved: 2026/02/04 17:14:16 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
떡 먹는 호랑이
피보나치
D : 넘어온 날
K : 해당 날의 떡 개수

A : 첫날 준 떡의 개수
B : 둘째 날 준 떡의 개수
A와 B 구하기

dp[n] = dp[n - 1] + dp[n - 2];
새로운 dp[n]이 기존보다 작으면 dp[2]++
새로운 dp[n]이 기존보다 크면 dp[1]++

1 2  3   5     8    13
A B A+B A+2B 2A+3B 3A+5B ...  -> 여기서도 피보나치
*/

import java.io.*;
import java.util.*;

public class Main{

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[d + 1][2];
        dp[1] = new int[]{1, 0};
        dp[2] = new int[]{0, 1};

        for (int i = 3; i <= d; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; 
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; 
        }
        
        int x = dp[d][0];       // a의 계수
        int y = dp[d][1];       // b의 계수

        for (int a = 1; ; a++) {
            int rest = k - x * a;
            if (rest <= 0) break;
            if (rest % y == 0) {
                int b = rest / y;
                if (b >= a) {         
                    System.out.println(a);
                    System.out.println(b);
                    break;
                }
            }
        }       
    }
}