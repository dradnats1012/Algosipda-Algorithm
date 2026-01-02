/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1063                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1063                           #+#        #+#      #+#    */
/*   Solved: 2026/01/01 22:50:37 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*String[] dir = {"T", "B", "RT", "R", "RB", "LT", "L", "LB"};

*/

import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static Map<String, int[]> move = new HashMap<>();
  private static Map<String, Integer> mapper = new HashMap<>();
  private static final Map<Integer, String> reverseMapper = new HashMap<>();
  public static void main(String[] args) throws IOException {
    move.put("R",  new int[]{ 1,  0});
    move.put("L",  new int[]{-1,  0});
    move.put("B",  new int[]{ 0, -1});
    move.put("T",  new int[]{ 0,  1});
    move.put("RT", new int[]{ 1,  1});
    move.put("LT", new int[]{-1,  1});
    move.put("RB", new int[]{ 1, -1});
    move.put("LB", new int[]{-1, -1});

    mapper.put("A", 1);
    mapper.put("B", 2);
    mapper.put("C", 3);
    mapper.put("D", 4);
    mapper.put("E", 5);
    mapper.put("F", 6);
    mapper.put("G", 7);
    mapper.put("H", 8);

    reverseMapper.put(1, "A");
    reverseMapper.put(2, "B");
    reverseMapper.put(3, "C");
    reverseMapper.put(4, "D");
    reverseMapper.put(5, "E");
    reverseMapper.put(6, "F");
    reverseMapper.put(7, "G");
    reverseMapper.put(8, "H");

    StringTokenizer st = new StringTokenizer(br.readLine());
    String[] kPos = st.nextToken().split("");
    int kXPos = mapper.get(kPos[0]);
    int kYPos = Integer.parseInt(kPos[1]);
    String[] rPos = st.nextToken().split("");
    int rXPos = mapper.get(rPos[0]);
    int rYPos = Integer.parseInt(rPos[1]);
    int t = Integer.parseInt(st.nextToken());


    for (int i = 0; i < t; i++) {
      String dir = br.readLine();
      int[] nowDir = move.get(dir);

      int nkx = kXPos + nowDir[0];
      int nky = kYPos + nowDir[1];

      if (nkx >= 1 && nkx <= 8 && nky >= 1 && nky <= 8) {
        if (nkx == rXPos && nky == rYPos) {
          int nrx = rXPos + nowDir[0];
          int nry = rYPos + nowDir[1];

          if (nrx >= 1 && nrx <= 8 && nry >= 1 && nry <= 8) {
            kXPos = nkx; kYPos = nky;
            rXPos = nrx; rYPos = nry;
          }
        } else {
          kXPos = nkx; kYPos = nky;
        }
      }
    }

    System.out.println(reverseMapper.get(kXPos) + kYPos);
    System.out.println(reverseMapper.get(rXPos) + rYPos);
  }
}