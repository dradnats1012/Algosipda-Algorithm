package baekjun.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2458 {

    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;

        arr = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], false);      // 배열 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (arr[j][i] && arr[i][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (arr[i][j] || arr[j][i]) {
                    count += 1;
                }
            }
            if (count == n - 1) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
