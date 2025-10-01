package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Integer> tShirts = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            tShirts.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int sumT = 0;
        for (int j = 0; j < 6; j++) {
            int a = tShirts.get(j) / T;
            if(tShirts.get(j) % T != 0){
                a += 1;
            }

            sumT += a;
        }

        System.out.println(sumT);
        System.out.println(N / P + " " + N % P);
    }
}
