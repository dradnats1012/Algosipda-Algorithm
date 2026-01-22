/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18353                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18353                          #+#        #+#      #+#    */
/*   Solved: 2026/01/20 12:36:14 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
n명의 병사 무작위 나열
병사별 전투력 
전투력이 높은 병사가 앞쪽으로 내림차순
특정 위치 병사 열외하면서 남아 있는 병사의 수가 최대

선택을 했을때 지금까지의 최대보다 길다 -> 갱신
같다 -> 해당 수 비교해서 더 큰 수 고름
*/


import java.io.*;
import java.util.*;

public class Main{
  
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dp;
  private static int[] arr;
  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0 ; i < n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int lds = 0;

    for(int i = 0; i < n; i++) {
      dp[i] = 1;
      for(int j = 0; j < i; j++){
        if(arr[j] > arr[i]) {   // 다음이 더 작으면
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      lds = Math.max(lds, dp[i]);
    }
    
    System.out.println(n - lds);
  }
}