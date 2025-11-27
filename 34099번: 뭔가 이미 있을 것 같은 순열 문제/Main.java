/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 34099                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/34099                          #+#        #+#      #+#    */
/*   Solved: 2025/11/27 15:42:10 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*

*/


import java.io.*;
import java.util.*;

public class Main{

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException{
    int t = Integer.parseInt(br.readLine());

    for(int i = 0; i < t; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      if(n < 4 && k == 1) System.out.println("-1");

      else if(n == 4 && k == 1) {
        for(int j = 2; j <= n; j+=2){
          System.out.print(j + " ");
        }
        for(int j = 1; j <= n; j+=2){
          System.out.print(j + " ");
        }
        System.out.println();
      }

      else if(k == 1) {
        for(int j = 1; j <= n; j+=2){
          System.out.print(j + " ");
        }
        for(int j = 2; j <= n; j+=2){
          System.out.print(j + " ");
        }
        System.out.println();
      }

      else {
        for(int j = 1; j <= n; j++){
          System.out.print(j + " ");
        }
        System.out.println();
      }
    }
  }
}