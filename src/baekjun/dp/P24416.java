package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(recurFib(n));
        System.out.println(dpFib(n));
    }

    private static int recurFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return (recurFib(n - 1) + recurFib(n - 2));
        }
    }

    private static int dpFib(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        int count = 1;

        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            count++;
        }
        return count;
    }
}
