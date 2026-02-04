/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2667                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2667                           #+#        #+#      #+#    */
/*   Solved: 2026/01/23 09:54:38 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
집 : 1, 땅 : 0

연결된 집(상하좌우) -> 단지 -> 번호를 붙임
단지수 출력, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
BFS겠군
*/


import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[][] map;     // 지도 배열
  private static boolean[][] visited; // 방문처리 배열
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static List<Integer> result = new ArrayList<>();
  private static Queue<int[]> q = new ArrayDeque<int[]>();

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];

    for(int i = 0; i < n; i++) {
      String[] line = br.readLine().split("");
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(line[j]);
      }
    }
    
    int now = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(map[i][j] == 1 && visited[i][j] == false){
          result.add(0);
          visited[i][j] = true;
          result.set(now, result.get(now) + 1);
          q.add(new int[]{i, j});   // 큐에 넣어
          while(!q.isEmpty()){      // 큐가 빌때까지 돌려
            int[] nowPos = q.poll();
            for(int k = 0; k < 4; k++){   // 상하좌우 검사해
              int nx = nowPos[0] + dx[k];
              int ny = nowPos[1] + dy[k];
              if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {    // 범위 내면
                result.set(now, result.get(now) + 1);   // 집 개수 추가 
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
              }
            }
          }
          now++;
        }
      }
    }

    Collections.sort(result);
    System.out.println(result.size());
    for(int i = 0; i < result.size(); i++){
      System.out.println(result.get(i));
    }
  }
}