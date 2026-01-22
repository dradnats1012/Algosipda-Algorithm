/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3758                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3758                           #+#        #+#      #+#    */
/*   Solved: 2026/01/22 17:49:07 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
K개의 문제
0~100 점수
한 문제에 대한 풀이중 최고 점수가 최종 점수 - 미제출시 0
팀 점수 = 총합

점수 동일 시 
- 풀이를 제출한 횟수가 적은 팀
- 마지막 제출 시간이 더 빠른 팀


*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringTokenizer st;
  private static int[][] team;
  private static int[][] score;

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());  // 테스트 데이터의 수
    
    
    for(int i = 0; i < t; i++){
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 팀의 개수
      int k = Integer.parseInt(st.nextToken()); // 문제의 개수
      int id = Integer.parseInt(st.nextToken()); // 팀 아이디
      int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수
      team = new int[n + 1][3];   // [x][0] 은 총 점수, [x][1]은 제출 횟수, [x][2]는 마지막 제출
      score = new int[n + 1][k + 1];

      for(int j = 0; j < m; j++){
        st = new StringTokenizer(br.readLine());
        int nId = Integer.parseInt(st.nextToken());   // 현재 팀 아이디
        int nJ = Integer.parseInt(st.nextToken());    // 현재 문제 번호
        int ns = Integer.parseInt(st.nextToken());    // 점수

        if(ns > score[nId][nJ]){            // 현재 점수가 더 크면
          team[nId][0] -= score[nId][nJ];
          score[nId][nJ] = ns;
          team[nId][0] += ns;
          team[nId][1]++;
          team[nId][2] = j;
        } else {
          team[nId][1]++;
          team[nId][2] = j;
        }
      }
      int rank = 1;

      for(int p = 1; p <= n; p++){
        if(p == id) continue;   // 우리팀은 패스
        if(team[p][0] == team[id][0]){  // 총점이 같음
          if(team[p][1] == team[id][1]){   // 제출 횟수가 같음
            if(team[p][2] < team[id][2]){   // 우리보다 일찍 냄
              rank++;
            }
          } else if(team[p][1] < team[id][1]){
            rank++;
          }
        } else if(team[p][0] > team[id][0]){
          rank++;
        }
      }
      System.out.println(rank);
    }
  }
}