/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17610                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17610                          #+#        #+#      #+#    */
/*   Solved: 2025/12/08 14:19:52 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */


import java.io.*;
import java.util.*;

public class Main{
  
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static void main(String[] args) throws IOException {
    int k = Integer.parseInt(br.readLine());
    int[] arr = new int[k];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int s = 0;
    
    for(int i = 0; i < k; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      s += arr[i];
    }
    
    boolean[] possible = new boolean[s + 1];
    possible[0] = true;

    for(int w : arr){
      boolean[] cha = new boolean[s + 1];
      for(int i = 0; i <= s; i++){
        if(!possible[i]) continue;  // 만들 수 없는 차이면 패스

        int w1 = i + w;           // 무거운쪽 넣는경우
        int w2 = Math.abs(i - w); // 가벼운쪽 넣는경우
        
        if(w1 <= s) cha[w1] = true;
        if(w2 <= s) cha[w2] = true;
      }

      for(int i = 0; i <= s; i++){
        if(cha[i]) possible[i] = true;
      }
    }

    int count = 0;
    for(int i = 1; i <= s; i++){
      if(!possible[i]) {count++;}
    }

    System.out.println(count);
  }
}




/*
양쪽 저울의 차를 만들 수 있는지?
- 추 하나만 올려도 되는 경우 -> 해결
- 추 2개만 올려도 되는 경우 -> 해결
- 추 3개 이상이 필요한 경우
  - 양쪽에 올라가는 경우를 어떻게 판별하지?????? -> 양쪽에 올라간건 어차피 둘다 뺴면 차이 똑같아서 상관없음
  - 차이를 만들 수 있는가가 관건인듯
*/