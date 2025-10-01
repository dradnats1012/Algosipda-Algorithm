package baekjun.nsalgo.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3107 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input = br.readLine();

        String[] parts;

        if (input.contains("::")) {
            String[] tmp = input.split("::");

            String[] left = tmp[0].equals("") ? new String[0] : tmp[0].split(":");                          // 왼쪽 배열 쪼갬
            String[] right = (tmp.length == 2 && !tmp[1].equals("")) ? tmp[1].split(":") : new String[0];   // 오른쪽 배열 쪼갬

            int fillCount = 8 - (left.length + right.length);   //

            parts = new String[8];
            int idx = 0;

            for (String s : left) {
                parts[idx++] = s;
            }

            for (int i = 0; i < fillCount; i++) {
                parts[idx++] = "0";
            }

            for (String s : right) {
                parts[idx++] = s;
            }
        } else {
            parts = input.split(":");
        }

        for (int i = 0; i < 8; i++) {
            String block = parts[i];
            while (block.length() < 4) {
                block = "0" + block;
            }
            System.out.print(block);
            if (i != 7) System.out.print(":");
        }
    }
}