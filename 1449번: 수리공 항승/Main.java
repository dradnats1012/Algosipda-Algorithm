/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1449                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1449                           #+#        #+#      #+#    */
/*   Solved: 2025/12/10 14:28:35 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
정렬 필요
하나의 테이프로 최대한 많은 구멍을 막아야 함
위치 - 위치 + 1 이 필요한 테이프의 길이
*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int[] pos;

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // 물이 새는 곳의 개수
    int l = Integer.parseInt(st.nextToken());   // 테이프의 길이 

    pos = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      pos[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(pos);

    int count = 0;
    for(int i = 0; i < n; i++){
      count++;
      int end = pos[i] + l - 1;   // 최대로 막을 수 있는 구멍 위치
      int j = i;                  // i의 위치부터 검사
      while(j < n && pos[j] <= end){  // 배열보다 작고, 막히는 부분에 있으면 다음 구멍 검사
        j++;
      }
      i = j - 1;    // 반복문 탈출시 +1 방지
    }

    System.out.println(count);
  }
}