package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 2;

        while (true) {
            if (num == 1)
                break;

            if (num % i == 0) {
                num /= i;
                System.out.println(i);
            } else
                i++;
        }
    }
}
