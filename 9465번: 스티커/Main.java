/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9465                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9465                           #+#        #+#      #+#    */
/*   Solved: 2025/12/04 16:47:11 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException{
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for(int i = 0 ; i < t; i++){
      int n = Integer.parseInt(br.readLine());
      int[][] map = new int[2][n];
      int[][] dp = new int[3][n];    

      for(int j = 0; j < 2; j++){
        st = new StringTokenizer(br.readLine());
        for(int k = 0; k < n; k++){
          map[j][k] = Integer.parseInt(st.nextToken());
        }
      }

      dp[0][0] = map[0][0];   // 위
      dp[1][0] = map[1][0];   // 아래
      dp[2][0] = 0;           // 선택 안함

      for(int j = 1; j < n; j++){
        dp[0][j] = Math.max(dp[1][j - 1], dp[2][j - 1]) + map[0][j];
        dp[1][j] = Math.max(dp[0][j - 1], dp[2][j - 1]) + map[1][j];
        dp[2][j] = Math.max(dp[0][j - 1], Math.max(dp[1][j - 1], dp[2][j - 1]));  // 큰놈 아무나 와라
      }
      int answer = Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1]));
      System.out.println(answer);
    }
  }
}