/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2195                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2195                           #+#        #+#      #+#    */
/*   Solved: 2026/02/09 18:14:44 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/*
2195번 : 문자열 복사
원본 문자열 S 
부분복사 문자열 P

copy(s,p) 함수 이용 -> S의 s부터 p개의 문자열을 P 뒤에 붙임
copy 함수를 가능한 한 가장 적게 사용하는 횟수 구하기

최장 증가 수열인가
P의 앞부분부터 검사하면서 하나씩 검사를 해?
1000개면 감당이 될 수도 1000 * 1000 = 천만? 오 되나

p의 0부터 시작해서 s랑 검사 -> 같은거 있으면 p의 범위를 1 늘림?

*/

import java.io.*;
import java.util.*;

public class Main{

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String P = br.readLine();

        int ans = 0;                // 횟수 계산 용도
        int i = 0;                  // p의 0번부터 시작

        while(i < P.length()){
            int best = 0;

            for(int j = 0; j < S.length(); j++){
                int len = 0;
                while (j + len < S.length() && i + len < P.length()    
                    && S.charAt(j + len) == P.charAt(i + len)) {    // 계속 비교하면서 갱신
                    len++;      // 같으면 len++ 해서 또 검사
                }
                if (len > best) best = len;     // 최고값 비교
            }
            i += best;
            ans++;
        }

        System.out.println(ans);
    }
}