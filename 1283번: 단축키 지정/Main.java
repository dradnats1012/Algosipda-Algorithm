/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1283                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1283                           #+#        #+#      #+#    */
/*   Solved: 2025/12/02 22:57:34 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.*;
import java.util.*;

public class Main{

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    boolean[] used = new boolean[26];
    int t = Integer.parseInt(br.readLine());

    for(int i = 0; i < t; i++){
      String word = br.readLine();
      int pos = -1;
      for(int j = 0; j < word.length(); j++){
        if(j == 0 || word.charAt(j - 1) == ' '){  // 단어 첫글자
          char now = word.charAt(j);
          if(now == ' ') continue;
          char low = Character.toLowerCase(now);
          int index = low - 'a';
          
          if(!used[index]){   // 사용하지 않았으면
            used[index] = true;
            pos = j;
            break;
          }
        }
      }

      if(pos == -1){
        for(int j = 0; j < word.length(); j++){
          char now = word.charAt(j);
          if(now == ' ') continue;
          char low = Character.toLowerCase(now);
          int index = low - 'a';

          if(!used[index]){   // 사용하지 않았으면
            used[index] = true;
            pos = j;
            break;
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      if(pos == -1){
        System.out.println(word);    
        continue;
      }

      for(int k = 0; k < word.length(); k++){
        if(k == pos){
          sb.append("[");
          sb.append(word.charAt(k));
          sb.append("]");
        } else {
          sb.append(word.charAt(k));
        }
      }
      System.out.println(sb);
    }
  }
}