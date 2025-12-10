/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1965                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1965                           #+#        #+#      #+#    */
/*   Solved: 2025/12/10 13:12:42 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
상자마다 크기가 주어짐
앞 상자의 크기가 뒷 상자보다 작으면 앞상자를 뒷상자에 넣음
*/

import java.io.*;
import java.util.StringTokenizer;
import java.io.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] arr;
  private static int[] dp;

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    arr = new int[n];
    dp = new int[n + 1];
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        if(arr[i] > arr[j]){
          dp[i] = Math.max(dp[i], dp[j] + 1);  // 기존 dp가 큰지 새로운거에 1 추가한게 큰지
        }
      }
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}