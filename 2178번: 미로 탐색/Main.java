/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2178                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2178                           #+#        #+#      #+#    */
/*   Solved: 2025/11/29 12:56:22 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
1 : 이동 가능한 칸
0 : 이ㅇ 불가능한 칸
(1,1)에서 출발, (N,M)까지 이동

지나야 하는 최소 칸 수
인접한 칸으로만 이동 가능 


*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static int[][] maze;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    maze = new int[n + 1][m + 1];

    for(int i = 0; i < n; i++){
      maze[i] = br.readLine().split("");
    }

    int count = 0;

    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= m; j++){
        for(int k = 0; k < 4; k++) {
          
        }
      }
    }
  }
}