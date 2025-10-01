package baekjun.nsalgo.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] directions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int length = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Point goal = new Point(Integer.parseInt(st.nextToken(), 10), Integer.parseInt(st.nextToken(), 10));

            int result = bfs(length, start, goal);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int bfs(int length, Point start, Point goal) {
        boolean[][] visited = new boolean[length][length];      // 방문 배열
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        int[][] dist = new int[length][length];

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.y == goal.y && cur.x == goal.x) {
                return dist[cur.y][cur.x];
            }

            for (int[] dir : directions) {
                int ny = cur.y + dir[0];
                int nx = cur.x + dir[1];

                if (ny >= 0 && ny < length && nx >= 0 && nx < length && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[cur.y][cur.x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }

        return -1;
    }
}
