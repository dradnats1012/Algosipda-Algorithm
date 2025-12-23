/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3184                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3184                           #+#        #+#      #+#    */
/*   Solved: 2025/12/11 13:33:14 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
늑대가 양 공격
마당은 직사각형
. : 빈 필드
# : 울타리
o : 양
v : 늑대

수평 수직만으로 이동 -> bfs 돌리면 될듯
울타리 내부의 크기를 재고 (., o, v) 그 안에서 양과 늑대의 수 세기
*/


import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static String[][] map;
  private static boolean[][] visited;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    map = new String[r][c];
    visited = new boolean[r][c];

    for(int i = 0; i < r; i++){
      map[i] = br.readLine().split("");
    }

    Queue<int[]> q = new ArrayDeque<>();
    int totalSheep = 0;
    int totalWolf = 0;

    for(int i = 0; i < r; i++){
      for(int j = 0; j < c; j++){
        if(!map[i][j].equals("#") && !visited[i][j]){
          int sheepCount = 0;
          int wolfCount = 0;
          q.add(new int[]{i,j});
          visited[i][j] = true;
          if (map[i][j].equals("o")) sheepCount++;
          if (map[i][j].equals("v")) wolfCount++;
          
          while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k = 0; k < 4; k++){
              int nx = now[0] + dx[k];
              int ny = now[1] + dy[k]; 
              if(nx >= 0 && nx < r && ny >= 0 && ny < c && !map[nx][ny].equals("#") && !visited[nx][ny]){  // 맵을 안벗어나고 울타리가 아니면
                q.add(new int[]{nx, ny});   // 큐에 추가
                visited[nx][ny] = true;     // 방문 처리
                if(map[nx][ny].equals("o")) sheepCount++; // 양이면
                if(map[nx][ny].equals("v")) wolfCount++;
              }
            }
          }
          if(wolfCount < sheepCount) totalSheep += sheepCount;
          else totalWolf += wolfCount;
        }
      }
    }

    System.out.println(totalSheep + " " + totalWolf);
  }
}