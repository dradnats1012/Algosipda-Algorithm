package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        int count = 0;

        for (int i = 0; ; i++) {
            str = Integer.toString(i);

            if (str.contains("666")) {
                count++;
            }

            if (count == N) {
                break;
            }
        }

        System.out.println(str);
    }
}
