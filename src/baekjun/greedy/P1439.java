package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;
        int i = 0;

        while (i < S.length()) {
            char currentChar = S.charAt(i);

            while (i < S.length() && S.charAt(i) == currentChar) {
                i++;
            }

            if (currentChar == '0') {
                zeroCount++;
            }

            if (currentChar == '1') {
                oneCount++;
            }
        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
