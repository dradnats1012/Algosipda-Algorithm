package baekjun.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class P2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> input;
        int count;

        while (true) {
            count = 0;
            input = List.of(br.readLine().split(""));
            if (Objects.equals(input.get(0), "#")) {
                break;
            }

            for (int i = 1; i < input.size(); i++) {
                if ((input.get(0).equalsIgnoreCase(input.get(i)))) {
                    count++;
                }
            }
            System.out.println(input.get(0) + " " + count);
        }

    }
}
