package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = 10000;
        int total = 0;
        int count = 0;

        for (int i = M; i <= N; i++) {
            if (checkNum(i)) {
                if (min > i) {
                    min = i;
                }
                total += i;
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(min);
        }
    }

    private static boolean checkNum(int i) {
        if(i == 1) return false;

        for (int j = 1; j <= i; j++) {
            if ((j != 1 && j != i) && i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
