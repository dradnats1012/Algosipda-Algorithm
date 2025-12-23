/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11501                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11501                          #+#        #+#      #+#    */
/*   Solved: 2025/12/23 12:19:02 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
주식
1. 주식 하나를 산다
2. 주식을 판다
3. 아무것도 안한다

최대 이익이 되는 경우를 계산
최대 이익 -> 싸게 사서 비싸게 판다

다음께 비싸면 팔면됨 -> 다다음이나 다다다음이나 다다다다음이 비싼건? 
아니면 팔았을때랑 안팔았을때랑 max를 찾는거임 -> dp인가
아니면 뒤에 있는 최대값을 찾아 -> 시작점 기준으로 -> 거기서 다 팔아
*/

import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for(int i = 0; i < t; i++){
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int[] day = new int[n];
      for(int j = 0; j < n; j++){
        day[j] = Integer.parseInt(st.nextToken());
      }

      int max = 0;
      long total = 0;

      for(int j = n - 1; j >= 0; j--){   // 뒤에서부터 최댓값 찾음 -> 매번 찾으면 안됨
        if(day[j] > max){
          max = Math.max(max, day[j]);
        } else total += (max - day[j]);   
      }

      System.out.println(total);
    }
  }
}
