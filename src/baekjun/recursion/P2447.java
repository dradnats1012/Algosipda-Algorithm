package baekjun.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {

    public static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        recursive(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recursive(int n, int x, int y) {
        if (n == 3) {               // 제일 작은 사각형
            for (int i = 0; i < 9; i++) {   // 제일 작은 사각형의 크기만큼 반복
                if (i != 4) {       // 4가 가운데 -> 빈칸
                    arr[x + i / 3][y + n / 3 * i % 3] = "*";
                } else {
                    arr[x + i / 3][y + n / 3 * i % 3] = " ";
                }
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (i != 4) {   // 마찬가지로 빈칸이 아니면 재귀적으로 실행
                recursive(n / 3, x + n / 3 * (i / 3), y + n / 3 * (i % 3));
            } else {        // 빈칸이면 가운데 뻥 뚫림
                drawBlank(n / 3, x + n / 3 * (i / 3), y + n / 3 * (i % 3));
            }
        }
    }

    // 가운데 빈칸을 그려주는 함수
    private static void drawBlank(int n, int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[x + i][y + j] = " ";
            }
        }
    }
}
