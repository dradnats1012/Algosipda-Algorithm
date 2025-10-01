package koreatech._20240706judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int price;

        List<Integer> arr = new ArrayList<>();

        int start;
        int last;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            last = Integer.parseInt(st.nextToken());

            for (int j = start; j < last; j++) {
                arr.add(j);
            }

            if (min < start) {
                min = start;
            }

            if (max > last) {
                max = last;
            }
        }

        price = Math.abs(max - min);

        for (int k = 0; k < arr.size(); k++) {
            if (Collections.frequency(arr, arr.get(k)) == N) {
                price = 0;
            }
        }

        System.out.print(price);
    }
}
