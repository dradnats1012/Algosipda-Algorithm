package baekjun.nsalgo.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2980 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] signs;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int time = 0;
        int d, r, g;
        signs = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            signs[i] = new int[] {d, r, g};
        }

        for (int j = 0; j < n; j++) {
            if (j == 0)
                time += signs[j][0];
            else
                time += signs[j][0] - signs[j - 1][0];

            int rg = signs[j][1] + signs[j][2];
            int temp = time % rg;
            if (temp - signs[j][1] < 0)
                time -= (temp - signs[j][1]);

            if (j == n - 1)
                time += l - signs[j][0];
        }

        System.out.println(time);
    }
}
