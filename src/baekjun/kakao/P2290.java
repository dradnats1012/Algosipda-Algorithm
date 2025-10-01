package baekjun.kakao;

import java.io.*;
import java.util.*;

public class P2290 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        for (int i = 0; i < (2 * s + 3); i++) {

            for(int j = 0; j < n.length(); j++){

                if (i == 0) {       // 맨 위
                    if (n.charAt(j) != '1' && n.charAt(j) != '4') {
                        System.out.print(" ");
                        for (int k = 0; k < s; k++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    } else {
                        for (int k = 0; k < s + 2; k++) {
                            System.out.print(" ");
                        }
                    }
                }

                if (1 <= i && i <= s) {     // 위쪽 몸
                    if (n.charAt(j) == '1' || n.charAt(j) == '2' || n.charAt(j) == '3' || n.charAt(j) == '7') {
                        for (int k = 0; k < s + 1; k++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    } else if (n.charAt(j) == '5' || n.charAt(j) == '6') {
                        System.out.print("|");
                        for (int k = 0; k < s + 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print("|");
                        for (int k = 0; k < s; k++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    }

                }

                if (i == s + 1) {       // 중간
                    if (n.charAt(j) == '1' || n.charAt(j) == '7' || n.charAt(j) == '0') {
                        for (int k = 0; k < s + 2; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                        for (int k = 0; k < s; k++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    }

                }

                if (s + 1 < i && i <= 2 * s + 1) {      // 아래쪽 몸
                    if (n.charAt(j) == '1' || n.charAt(j) == '3' || n.charAt(j) == '4' || n.charAt(j) == '5'
                        || n.charAt(j) == '7' || n.charAt(j) == '9') {
                        for (int k = 0; k < s + 1; k++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    } else if (n.charAt(j) == '2') {
                        System.out.print("|");
                        for (int k = 0; k < s + 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print("|");
                        for (int k = 0; k < s; k++) {
                            System.out.print(" ");
                        }
                        System.out.print("|");
                    }

                }

                if (i == 2 * s + 2) {

                    if (n.charAt(j) == '1' || n.charAt(j) == '4' || n.charAt(j) == '7') {
                        for (int k = 0; k < s + 2; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print(" ");
                        for (int k = 0; k < s; k++) {
                            System.out.print("-");
                        }
                        System.out.print(" ");
                    }
                }
                if (j < n.length() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


/*
가로 : s + 2
세로 : 2s + 3

맨 위 가로줄 2, 3, 5, 6, 7, 8, 9, 0
위쪽 몸 (1, 2, 3, 7 오른쪽만) (5, 6 왼쪽만) (4, 8, 9, 0 양쪽)
중간 2, 3, 4, 5, 6, 8, 9
아래쪽 몸 (1, 3, 4, 5, 7, 9 오른쪽만) (2 왼쪽만) (6, 8, 0 양쪽)
아래 2, 3, 5, 6, 8, 0

가로로 그리면서 내려가야 됨
 */
