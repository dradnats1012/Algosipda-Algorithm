/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14891                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14891                          #+#        #+#      #+#    */
/*   Solved: 2025/12/04 23:08:03 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
8개의 톱니를 가지고 있는 톱니바튀 4개 
톱니는 N극 또는 S극 중 하나를 나타냄

톱니바퀴를 총 K번 회전시키려고 함 -> 시계, 반시계 방향
회전시킬 톱니와 방향을 정해야 함
톱니를 회전할때, 맞닿은 톱니의 극이 다르다면, 반대 방향으로 회전

n극은 0, s극은 1
맞닿아 있는 인덱스 : 2, 6 -> 자신의 2와 오른쪽의 6비교, 자신의 6과 왼쪽의 2 비교
k : 회전 횟수
첫 정수 : 회전시킨 톱니의 번호, 두번째 정수 : 방향 (1은 시계, -1은 반시계)
*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static char[][] wheels = new char[4][8];

  public static void main(String[] args) throws IOException {
    for(int i = 0; i < 4; i++){
      String line = br.readLine();
      for(int j = 0; j < 8; j++){
        wheels[i][j] = line.charAt(j);
      }
    }
    
    int k = Integer.parseInt(br.readLine());  // 회전 횟수
    for(int t = 0; t < k; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()); // 번호
      int dir = Integer.parseInt(st.nextToken());

      int[] dirs = new int[4];
      int index = num - 1;
      dirs[index] = dir;

      for(int i = index - 1; i >= 0; i--){
        if(wheels[i][2] != wheels[i + 1][6]){
          dirs[i] = -dirs[i + 1];
        } else break;
      }

      for(int i = index + 1; i < 4; i++){
        if(wheels[i - 1][2] != wheels[i][6]){
          dirs[i] = -dirs[i - 1];
        } else break;
      }

      for (int i = 0; i < 4; i++) {
        if (dirs[i] != 0) {
            rotate(i, dirs[i]);
        }
      }
    }
    
    int total = 0;
    if(wheels[0][0] == '1') total += 1;
    if(wheels[1][0] == '1') total += 2;
    if(wheels[2][0] == '1') total += 4;
    if(wheels[3][0] == '1') total += 8;

    System.out.println(total);
  }

  private static void rotate(int index, int dir) {
    if(dir == 1){
      char tmp = wheels[index][7];
      for(int i = 7; i > 0; i--){
        wheels[index][i] = wheels[index][i - 1];
      }
      wheels[index][0] = tmp;
    }else {
      char tmp = wheels[index][0];
      for(int i = 0; i < 7; i++){
        wheels[index][i] = wheels[index][i + 1];
      }
      wheels[index][7] = tmp;
    }
  }
}