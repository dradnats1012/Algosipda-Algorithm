package baekjun.nsalgo.week4;

import java.io.*;
import java.util.StringTokenizer;

public class P18111 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] land;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        land = new int[n][m];
        int minH = 256;
        int maxH = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, land[i][j]);
                maxH = Math.max(maxH, land[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int h = minH; h <= maxH; h++) {
            int time = calc(h, n, m, b);
            if (time < minTime || (time == minTime && h > resultHeight)) {
                minTime = time;
                resultHeight = h;
            }
        }

        bw.write(minTime + " " + resultHeight);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calc(int targetHeight, int n, int m, int inventory) {
        int time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = land[i][j] - targetHeight;
                if (diff > 0) {
                    time += diff * 2;
                    inventory += diff;
                } else if (diff < 0) {
                    time += -diff;
                    inventory -= -diff;
                }
            }
        }

        if (inventory < 0) return Integer.MAX_VALUE;
        return time;
    }
}