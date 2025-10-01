package baekjun.nsalgo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16918 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static char[][] map;
    private static int[][] time;
    private static int[] dx = new int[] {-1, 1, 0, 0};
    private static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        time = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
                if (ch == 'O') {
                    time[i][j] = 0;
                } else {
                    time[i][j] = -1;
                }
            }
        }

        if (n == 1) {
            for (int i = 0; i < r; i++)
                System.out.println(new String(map[i]));
            return;
        }
        if (n % 2 == 0) {
            String row = "O".repeat(c);
            for (int i = 0; i < r; i++)   
                System.out.println(row);
            return;
        }

        int[] steps;
        if (n % 4 == 3) {
            steps = new int[] {2, 3};
        } else {
            steps = new int[] {2, 3, 4, 5};
        }
        for (int t : steps) {
            if (t % 2 == 0) {
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            time[i][j] = t;
                        }
            } else {
                boolean[][] clear = new boolean[r][c];
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        if (map[i][j] == 'O' && time[i][j] == t - 3) {
                            clear[i][j] = true;
                            for (int k = 0; k < 4; k++) {
                                int ni = i + dx[k], nj = j + dy[k];
                                if (0 <= ni && ni < r && 0 <= nj && nj < c)
                                    clear[ni][nj] = true;
                            }
                        }
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        if (clear[i][j]) {
                            map[i][j] = '.';
                            time[i][j] = -1;
                        }
            }
        }

        for (int i = 0; i < r; i++) {
            System.out.println(new String(map[i]));
        }
    }
}
