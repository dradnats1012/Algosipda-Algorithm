/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1713                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1713                           #+#        #+#      #+#    */
/*   Solved: 2026/01/06 12:41:19 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
후보 추천하기
시간 순을 어떻게? 배열 뒤로 가면서 찾기가 제일 나을수도?

*/


import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static List<Integer> frame = new ArrayList<>();   // 틀에 있는 애들
  private static boolean[] isFrame = new boolean[101];  // 틀에 있는지
  private static int[] count = new int[101];            // 추천수
  private static int[] time = new int[101];             // 들어온 시점

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());    // 사진틀
    int t = Integer.parseInt(br.readLine());    // 총 추천 수

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < t; i++) {
      int x = Integer.parseInt(st.nextToken());   // 추천
      
      if (isFrame[x]) {   // 이미 틀에 있으면
        count[x]++;
        continue;
      }

      if(frame.size() == n) {    // 틀이 꽉참 
        int out = frame.get(0);   // 첫번쨰 나갈놈
        for (int k = 1; k < frame.size(); k++) {  
          int id = frame.get(k);  // 돌면서 비교

          if (count[id] < count[out]) {  // 이전 나갈놈보다 작으면 
              out = id;  // 너가 나가
          } else if (count[id] == count[out]) { // 같으면
              if (time[id] < time[out]) {    // 시간 비교
                  out = id;
              }
          }
        }

        frame.remove((Integer) out);
        isFrame[out] = false;
        time[out] = 0;
        count[out] = 0;
      }
      // 틀이 안참 -> 그냥 넣음
      frame.add(x);
      time[x] = i;
      count[x] = 1;
      isFrame[x] = true;
    }      

    Collections.sort(frame);
    for(int id : frame) {
      System.out.print(id + " ");
    }
  }
}