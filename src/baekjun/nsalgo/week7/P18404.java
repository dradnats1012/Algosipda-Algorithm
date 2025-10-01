package baekjun.nsalgo.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18404 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] distance;
    private static int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    private static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());       //  체스판 크기
        int m = Integer.parseInt(st.nextToken());       //  상대말 수

        distance = new int[n + 1][n + 1];
        for (int[] row : distance) {
            Arrays.fill(row, -1);                   // 방문 안 한 곳 -1로 초기화
        }

        st = new StringTokenizer(br.readLine());
        int startx = Integer.parseInt(st.nextToken());
        int starty = Integer.parseInt(st.nextToken());

        bfs(startx, starty);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(distance[x][y] + " ");
        }

        System.out.print(sb);
    }

    private static void bfs(int startx, int starty) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startx, starty});
        distance[startx][starty] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}
