/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 23305                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/23305                          #+#        #+#      #+#    */
/*   Solved: 2025/11/27 13:21:25 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*수업 교환
N : 학생 수
Ai : i번 학생이 신청한 수업, 교환하고 싶은 수업 번호
Bi : i번 학생이 교환을 통해 수강하고 싶은 수업의 번호
수업 교환을 완료했을때 원하는 수업을 수강하지 못하는 학생의 수

A에서 가지고 있는 강의의 개수 세기
B에서 원하는 강의의 개수 세기


*/


import java.io.*;
import java.util.*;

public class Main{
  private static int[] a;
  private static int[] b;

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException{
    int n = Integer.parseInt(br.readLine());
    a = new int[n];
    b = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++){
      b[i] = Integer.parseInt(st.nextToken());
    }

    Map<Integer, Integer> map = new HashMap<>();

    for(int x : a) map.put(x, map.getOrDefault(x,0) + 1);

    int count = 0;

    for(int x : b) {
      if(map.getOrDefault(x, 0) > 0) {
        map.put(x, map.get(x) - 1);
      } else count++;
    }

    System.out.println(count);
  }
}