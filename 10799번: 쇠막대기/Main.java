/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10799                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: dmb07301 <boj.kr/u/dmb07301>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10799                          #+#        #+#      #+#    */
/*   Solved: 2025/10/27 14:31:49 by dmb07301      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int pieces = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else { // ')'
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    pieces += stack.size(); // 레이저
                } else {
                    pieces += 1;            // 막대의 끝
                }
            }
        }
        System.out.println(pieces);
    }
}

/*
쇠막대기 절단
쇠막대기를 겹치고 한번에 절단
위로 갈수록 짧아짐
자르는 레이저 적어도 하나 존재
레이저는 끝점과 겹치지 않음

() -> 레이저 - 괄호가 열렸다 바로 닫히면 레이저임 

전부 스택에 넣음
위에서부터 꺼냄

닫힌 괄호
-> 다음 스택도 닫혔으면 카운트++
-> 다음 스택이 열렸으면 레이저 -> 토탈에 카운트만큼 증가 

열린 괄호(열린 괄호로 끝날수는 없음)
-> 
-> 


