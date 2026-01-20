/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2961                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2961                           #+#        #+#      #+#    */
/*   Solved: 2026/01/19 17:59:05 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
재료 N개 
각 재료의 신맛 S와 쓴맛 B
음식의 신맛 : 재료의 신맛의 곱
음식의 쓴맛 : 재료의 쓴맛의 합

재료를 적절히 섞어 차이를 작게 만들기
재료는 적어도 하나 사용

신맛과 쓴맛의 차이가 가장 작은 요리의 차이 출력

조합을 만들고 브루트포스를 돌리고 차이가 제일 작은걸 갱신하기? -> 재료가 10개 이하라 ㄱㅊ을듯
조합 만드는 방법을 까먹엇다

*/


import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] ingredient;
  private static int n;
  private static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    ingredient = new int[n + 1][2];   // 0은 신맛, 1은 쓴맛

    for(int i = 1; i <= n; i++) {          // 재료 리스트
      StringTokenizer st = new StringTokenizer(br.readLine());
      ingredient[i][0] = Integer.parseInt(st.nextToken());
      ingredient[i][1] = Integer.parseInt(st.nextToken());
    }

    for(int j = 1; j <= n; j++) {         // 재료 j개를 뽑음
      combine(1, j, 1, 0);                // 항상 1부터 고르는데 j개씩 반복
    }
    System.out.println(min);
  }

  private static void combine(int start, int r, int sin, int sseun) {   
    if(r == 0) {    // 배열에서 몇개 뽑을지 -> 하나씩 줄여가다가 다 뽑으면 갱신
      min = Math.min(min, Math.abs(sin - sseun));   // 다 고르면 갱신
      return;
    }
    for(int i = start; i <= n; i++) {
      combine(i + 1, r - 1, sin * ingredient[i][0], sseun + ingredient[i][1]);   // 하나씩 뽑으면서 계산
    }
  }
}
