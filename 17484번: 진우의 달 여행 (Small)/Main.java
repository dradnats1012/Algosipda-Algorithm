/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17484                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17484                          #+#        #+#      #+#    */
/*   Solved: 2025/12/24 13:47:05 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
아래방향(좌하, 우하 포함)만 갈 수 있음
전에 움직인 방향으로 불가능 (하하, 좌하좌하, 우하우하) 불가능
달 도달에 필요한 연료의 최소값

dp같음
최종 목표 : 제일 적은 비용으로 달 가기
부분 목표 : 현 단계에서 가장 적은 비용 찾기
방향이 달라야 함 -> 선택하는 열의 번호가 달라야 함

처음엔 가장 작은거 선택하겠지
두번째에는 
*/

import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] arr;
  private static int[][][] dp;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    dp = new int[n][m][3];   // 3번째는 방향
    arr = new int[n][m];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    
  }
}