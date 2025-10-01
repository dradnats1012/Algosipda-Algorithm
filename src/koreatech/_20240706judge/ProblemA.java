package koreatech._20240706judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        int max = 0;
        int gap = 0;

        for (int i = 0; i < 8; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        for (int j = 0; j < 7; j++) {
            gap = arr.get(j) - arr.get(j + 1);
            if(Math.abs(gap) > max){
                max = Math.abs(gap);
            }
        }

        System.out.println(max);
    }
}
