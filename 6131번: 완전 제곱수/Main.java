/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 6131                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/6131                           #+#        #+#      #+#    */
/*   Solved: 2025/10/31 14:32:52 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    for(int a = 1; a <= 500; a++) {
      for(int b = 1; b - a <= 0; b++){
        if(a * a - b * b == n) count++;
      }
    }

    System.out.println(count);
  }
}

/*
 * 두 양의 정수 A와 B를 고름 (1 <= B <= A <= 500)
 * A의 제곱은 B의 제곱보다 N 만큼 크다
 * 조건을 만족하는 A, B 쌍의 개수
 */