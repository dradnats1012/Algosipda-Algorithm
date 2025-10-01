package baekjun.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 2;
        boolean found = false;

        while (end <= 100000) {
            int diff = end * end - start * start;

            if (diff == g) {
                System.out.println(end);
                found = true;
                end++;
            } else if (diff < g) {
                end++;
            } else {
                start++;
            }
        }

        if (!found) {
            System.out.println("-1");
        }
    }
}




/*
다이어트
G킬로그램이나 더 찜
G -> 성원이의 현재 몸무게 ^ 2 - 기억하고 있던 몸무게 ^ 2
현재 몸무게로 가능한 것을 모두 출려

입력
1 <= G <= 100,000

출력
가능한 성원이의 현재 몸무게를 오름차순으로 출력
가능한 몸무게가 없을 때는 -1

풀이
현재 몸무게와 기억하는 몸무게를 번갈아 가면서 1씩 올림
뺀 값이 G보다 작으면 -> 현재 몸무게 + 1
뺀 값이 G보다 크면 -> 기억하고 있던 몸무게 + 1
뺀 값이 G와 같으면 -> 배열에 추가
 */