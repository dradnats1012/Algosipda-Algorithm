package baekjun.nsalgo.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8911 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] dx = {1, 0, -1, 0};      // 동, 북, 서, 남
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            String cmds = br.readLine();

            int x = 0;
            int y = 0;
            int dir = 1;

            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;

            for (int i = 0; i < cmds.length(); i++) {
                char cmd = cmds.charAt(i);

                if (cmd == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (cmd == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (cmd == 'L') {
                    dir = (dir + 1) % 4;
                } else if (cmd == 'R') {
                    dir = (dir + 3) % 4;
                }

                // 최대/최소 좌표 갱신
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
    }
}
