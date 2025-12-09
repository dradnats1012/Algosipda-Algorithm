/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15649                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15649                          #+#        #+#      #+#    */
/*   Solved: 2025/12/09 16:26:18 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{

  private static int[] arr;
  private static int[] output;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[n + 1];
    for(int i = 1; i <= n; i++){
      arr[i] = i;
    }
    output = new int[m];
    boolean[] visited = new boolean[n + 1];

    permutation(arr, output, visited, 0, n, m);
  }

  private static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int m){
    if(depth == m) {
      StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(output[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
        return;
    }

    for(int i = 1; i <= n; i++){
      if(visited[i] != true){   // 방문 안했으면
        visited[i] = true;
        output[depth] = arr[i]; // 현재 숫자 넣음
        permutation(arr, output, visited, depth + 1, n, m);
        visited[i] = false;
      }
    }
  }
}