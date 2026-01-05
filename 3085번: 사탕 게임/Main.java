/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3085                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3085                           #+#        #+#      #+#    */
/*   Solved: 2026/01/05 14:36:49 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
사탕게임

N x N 크기 
사탕의 색이 다른 인접한 두 칸을 고름
사탕 교화 -> 모두 같은 색으로 이루어진 가장 긴 연속 부분을 고르고 행이나 열을 먹음
먹을 수 있는 사탕의 최대 개수

설마 다 바꿔보면서 개수 체크 해야되나?????
개귀찮네

4방향? -> 그냥 우,하 만 검사하면 다 될듯?
*/

import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static String[][] arr;
  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    arr = new String[n][n];

    for(int i = 0; i < n; i++) {
      arr[i] = br.readLine().split("");
    }
    int rMax = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++){
        if(i + 1 < n) {
          swap(i, j, i + 1, j);
          rMax = Math.max(rMax, checkLines(i, j, i + 1, j));
          swap(i, j, i + 1, j);
        } 
        
        if(j + 1 < n) {
          swap(i, j, i, j + 1);
          rMax = Math.max(rMax, checkLines(i, j, i, j + 1));
          swap(i, j, i, j + 1);
        }
      }
    }

    System.out.println(rMax);
  }

  private static int checkLines(int x1, int y1, int x2, int y2) {
    int max = 1;
    
    max = Math.max(max,maxInRow(x1));
    max = Math.max(max,maxInRow(x2));
    max = Math.max(max,maxInCol(y1));
    max = Math.max(max,maxInCol(y2));

    return max;
  }

  private static int maxInRow(int r) {
    int n = arr.length;
    int best = 1, cnt = 1;
    for (int c = 1; c < n; c++) {
        if (arr[r][c].equals(arr[r][c - 1])) cnt++;
        else cnt = 1;
        if (cnt > best) best = cnt;
    }
    return best;
}

private static int maxInCol(int c) {
    int n = arr.length;
    int best = 1, cnt = 1;
    for (int r = 1; r < n; r++) {
        if (arr[r][c].equals(arr[r - 1][c])) cnt++;
        else cnt = 1;
        if (cnt > best) best = cnt;
    }
    return best;
}

  private static void swap(int x1, int y1, int x2, int y2) {
    String temp = arr[x1][y1];
    arr[x1][y1] = arr[x2][y2];
    arr[x2][y2] = temp;
  }
}