/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15686                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15686                          #+#        #+#      #+#    */
/*   Solved: 2025/12/08 16:44:20 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
크기 N x N 도시
빈칸(0), 치킨집(1), 집(2)
치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
도시의 치킨 거리 : 모든 집의 치킨 거리의 합
도시에 있는 치킨집 중 최대 M개를 고르고, 나머지 치킨집 폐업

도시 치킨 거리 최솟값

BFS?

조합으로 M개 뽑고 최소 거리 구해보기 ㄱㄱ
재귀로 조합?
각 집별로 치킨집을 순회하면서 가장 짧은 거리를 더함

치킨집에서 M개 뽑음
특정 집과 치킨집의 치킨 거리 구해서 더하기
*/

import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int[] output;  // 임시 배열
  private static List<int[]> result = new ArrayList<>();    // 조합 결과 저장 배열
  private static List<int[]> house = new ArrayList<>();     // 집 위치 저장 배열
  private static List<int[]> chicken = new ArrayList<>();   // 치킨 위치 저장 배열

  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    output = new int[m];    // 임시 배열 초기화 -> 조합 개수

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++){
        int now = Integer.parseInt(st.nextToken());
        if(now == 1) house.add(new int[]{i, j});    // 집 배열에 넣기
        if(now == 2) chicken.add(new int[]{i, j});  // 치킨 배열에 넣기
      }
    }

    comb(0, 0, chicken.size(), m); // 조합 result 배열에 저장

    int min = 1000000;
    for(int i = 0; i < result.size(); i++){ // 조합에서 꺼내서 최소 거리 검사
      int[] nowChicken = result.get(i);
      int total = 0;
      for(int k = 0; k < house.size(); k++){
        int[] nowHouse = house.get(k);
        int chiMin = 1000000;
        for(int j = 0; j < nowChicken.length; j++){ // 뽑은 치킨집의 인덱스만 있음
          int nowDis = calculate(nowHouse, chicken.get(nowChicken[j]));
          chiMin = Math.min(nowDis, chiMin);
        }
        total += chiMin;
      }
      min = Math.min(total, min);
    }

    System.out.println(min);
  }

  private static void comb (int start, int depth, int n, int r){
    if(depth == r){
      int[] temp = Arrays.copyOf(output, r);
      result.add(temp);
      return;
    }
    for(int i = start; i < n; i++){
      output[depth] = i;     
      comb(i + 1, depth + 1, n, r);
    }
  }

  private static int calculate(int[] h, int[] c){   // 집과 치킨집 사이의 거리 계산
    int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
    return distance;
  }
}