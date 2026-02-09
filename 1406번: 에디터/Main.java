/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1406                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1406                           #+#        #+#      #+#    */
/*   Solved: 2026/02/05 17:59:58 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/*
에디터
영어 고문자만 기록 가능
커서는 문장 어느곳에나 위치 가능 -> 길이가 L인 문자열에 L+1 경우의 수
처음 위치는 맨 뒤 

배열을 어떻게 관리? -> 정적 배열은 무리무리
동적 배열 List? -> 시간 초과로 실패

*/

import java.io.*;
import java.util.*;

public class Main{

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static Deque<String> leftQ = new LinkedList<>();
    private static Deque<String> rightQ = new LinkedList<>();
    private static String[] s;

    public static void main(String[] agrs) throws IOException {
        s = br.readLine().split("");    // 문장 저장 배열
        for(String a : s) {
            leftQ.add(a);           // 초기 데이터 좌측 큐에
        }
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            if(now.equals("P")){              // 왼쪽에 삽입
                String newWord = st.nextToken();       // 새로 올 문자
                leftQ.addLast(newWord);          // 왼쪽에 값 추가
            }
            else if(now.equals("L")) {
                String nowE = leftQ.pollLast();
                if(nowE != null) rightQ.offerFirst(nowE);
            }
            else if(now.equals("D")) {
                String nowE = rightQ.pollFirst();
                if(nowE != null) leftQ.offerLast(nowE);
            }
            else if(now.equals("B")) {
                leftQ.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String ch : leftQ) sb.append(ch);
        for (String ch : rightQ) sb.append(ch);
        System.out.print(sb);
    }
}