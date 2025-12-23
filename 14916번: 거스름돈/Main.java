/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14916                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14916                          #+#        #+#      #+#    */
/*   Solved: 2025/12/11 16:41:05 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
특정 액수가 되어야 함 -> dp로 되나? dp가 실버5에 있을수 있나

*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] dp;

  public static void main(String[] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    if(n == 1 || n == 3) {
      System.out.println(-1); 
      return;
    }
    
    while(n > 0) {
      if(n % 5 == 0) {
        count += n / 5;
        n = 0;
      } else {
        n -= 2;
        count++;
      }
    }
    
    System.out.println(count);
  }
}