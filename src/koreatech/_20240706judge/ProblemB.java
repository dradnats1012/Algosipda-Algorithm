package koreatech._20240706judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int seq = 0;

        for (int i = 2; i <= num; i++) {

            if (checkNum(i)) {
                seq++;
            }
        }

        System.out.println(seq);
    }

    private static boolean checkNum(int i) {
        for (int j = 1; j <= i; j++) {
            if ((j != 1 && j != i) && i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
