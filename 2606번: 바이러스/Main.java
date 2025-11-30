/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2606                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2606                           #+#        #+#      #+#    */
/*   Solved: 2025/11/30 14:49:18 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
바이러스 
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력

1 <= 컴퓨터의 수 <= 100
네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

이어져있는 컴퓨터의 수 구하기? 어떻게?
*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] map;
  private static Queue<Integer> q = new ArrayDeque<>();
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    int c = Integer.parseInt(br.readLine());
    map = new int[c + 1][c + 1];
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    visited = new boolean[c + 1];
    visited[1] = true;

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      map[a][b] = 1;
      map[b][a] = 1;
    }

    q.add(1);
    int count = 0;

    while(!q.isEmpty()){
      int cur = q.poll();
      for(int i = 1; i <= c; i++){
        if(map[cur][i] == 1 && !visited[i]){
          q.add(i);
          count++;
          visited[i] = true;
        }
      }
    }
    System.out.println(count);
  }
}