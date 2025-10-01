package baekjun.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P11582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String inputScore = br.readLine();
        List<Integer> scores = Arrays.stream(inputScore.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int k = Integer.parseInt(br.readLine());
        int size = n / k;

        int start = 0;

        for (int i = 0; i < k; i++) {
            Collections.sort(scores.subList(start, start + size));

            start += size;
        }

        for(int i : scores){
            System.out.print(i + " ");
        }
    }
}
