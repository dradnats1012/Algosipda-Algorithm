package baekjun.nsalgo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1515 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String num = br.readLine();
        int base = 0;
        int point = 0;

        while (base++ <= 30000) {
            String pNum = Integer.toString(base);
            for (int i = 0; i < pNum.length(); i++) {
                if (pNum.charAt(i) == num.charAt(point)) {        // 가리키는 숫자를 포함하면
                    point++;
                }
                if (point == num.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }

    }
}
